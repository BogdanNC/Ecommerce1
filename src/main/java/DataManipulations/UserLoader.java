package DataManipulations;

import Database.Database;
import UserPack.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class UserLoader implements DataLoader {

    private ArrayList<User> userList;
    Database database = Database.getDatabase();
    @Override
    public void loadFromJsonFile(String filePath) {
        File userFile = new File(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.userList = objectMapper.readValue(userFile, new TypeReference<ArrayList<User>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        saveToDatabase();
    }

    @Override
    public void saveToDatabase() {
        database.setUserList(this.userList);
        database.setUserIndexCounter(database.getUserList().get(database.getUserList().size() - 1).getUserId());
    }
    public void writeToJsonFile(String filePath) {
        File userFile = new File(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        this.userList = database.getUserList();
        try {
            objectMapper.writeValue(userFile, this.userList);
            System.out.println("user info stored in users.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
