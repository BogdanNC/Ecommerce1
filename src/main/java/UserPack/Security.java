package UserPack;

import Database.Database;

import java.util.ArrayList;
import java.util.HashMap;

public class Security {
    private Integer userId;
    private String pass;

    Database database = Database.getDatabase();

    public Integer createUniqueID () {
        Integer index = database.getUserIndexCounter();
        index++;
        database.setUserIndexCounter(index);
        return index;
    }

    public boolean checkUniqueEmail (String email) {
        ArrayList<User> userList = database.getUserList();
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
    public boolean checkPasswordEmailMatch (String email, String passwd) {
        ArrayList<User> userList = database.getUserList();
        HashMap<Integer, String> indexAndPasswd = database.getIndexAndPasswd();
        for ( User user : userList) {
            if(user.getEmail().equals(email)) {
                Integer userId = user.getUserId();
                if (indexAndPasswd.get(userId).equals(passwd)) {
                    System.out.println("Welcome " + user.getName() + " !");
                    return true;
                } else {
                    System.out.println("incorrect password");
                    return false;
                }
            }
        }
        System.out.println("incorrect email");
        return false;
    }
}
