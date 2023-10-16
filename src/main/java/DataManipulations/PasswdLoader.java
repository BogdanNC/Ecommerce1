package DataManipulations;

import Database.Database;
import UserPack.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PasswdLoader implements DataLoader {

    private HashMap <Integer, String> indexAndPasswd;
    Database database = Database.getDatabase();
    @Override
    public void loadFromJsonFile(String filePath) {
        File userFile = new File(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.indexAndPasswd = objectMapper.readValue(userFile, new TypeReference<HashMap <Integer, String>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        saveToDatabase();
    }

    @Override
    public void saveToDatabase() {
        database.setIndexAndPasswd(this.indexAndPasswd);
    }

    public void writeToJsonFile(String filePath) {
        File PasswdFile = new File(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        this.indexAndPasswd = database.getIndexAndPasswd();
        try {
            objectMapper.writeValue(PasswdFile, this.indexAndPasswd);
            System.out.println("password info stored in passwd.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
