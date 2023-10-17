package Manager;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import Database.MongoDB;

public class AccountManager {
    MongoDB mongoClient = new MongoDB();

    public String createAccount(String username, String email, String password) throws Exception {
        MongoClient client = mongoClient.connectDB();

        MongoCollection<Document> usersCollection = mongoClient.getCollection("users", client);
        MongoCollection<Document> passwordCollection = mongoClient.getCollection("passwords", client);

        if (usersCollection.find(Filters.eq("email", email)).first() != null) {
            throw new Exception("An account with this email already exists");
        }

        Document userDocument = new Document("username", username).append("email", email);
        usersCollection.insertOne(userDocument);

        Object userID = userDocument.get("_id");

        Document passwordDocument = new Document("password", password).append("userID", userID);
        passwordCollection.insertOne(passwordDocument);

        client.close();

        return "Success";
    }

    public boolean login(String email, String password) {
        MongoClient client = mongoClient.connectDB();

        MongoCollection<Document> usersCollection = mongoClient.getCollection("users", client);
        MongoCollection<Document> passwordCollection = mongoClient.getCollection("passwords", client);

        // Find the user document by email
        Document userDocument = usersCollection.find(Filters.eq("email", email)).first();

        if (userDocument != null) {
            // If a user with the specified email exists, get the user's _id
            Object userID = userDocument.get("_id");

            // Find the password document by userID
            Document passwordDocument = passwordCollection.find(Filters.eq("userID", userID)).first();

            if (passwordDocument != null) {
                // Check if the provided password matches the stored password
                String storedPassword = passwordDocument.getString("password");

                if (storedPassword.equals(password)) {
                    client.close();
                    System.out.println(storedPassword);
                    return true; // Login successful
                }

                client.close();
                System.out.println("Incorrect password");
                return false;
            }
        }

        client.close();
        System.out.println("No accounts are associated with this email");
        return false;
    }
}
