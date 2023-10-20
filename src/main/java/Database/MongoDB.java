package Database;

import com.mongodb.*;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
    private MongoClient connect() {
        // Replace the placeholder with your Atlas connection string
        String uri = "mongodb+srv://mongo:LFUqEF7C2wz5UOvt@ecomm.zaik6wq.mongodb.net";
        // Construct a ServerApi instance using the ServerApi.builder() method
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server
        try {
            MongoClient mongoClient = MongoClients.create(settings);
            return mongoClient;
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public MongoClient connectDB() {
        return connect();
    }

    public MongoCollection<Document> getCollection(String collectionName, MongoClient client) {
        MongoDatabase database = client.getDatabase("ecomm");
        return database.getCollection(collectionName);
    }
}
