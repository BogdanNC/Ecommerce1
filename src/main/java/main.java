import DataManipulations.PasswdLoader;
import DataManipulations.UserLoader;
import Database.Database;
import UserPack.Security;
import UserPack.User;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class main {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        Database database = Database.getDatabase();
        UserLoader userLoader = new UserLoader();
        PasswdLoader passwdLoader = new PasswdLoader();

        String userFilePath = "users.json";
        String passwdFilePath = "passwd.json";

        userLoader.loadFromJsonFile(userFilePath);
        passwdLoader.loadFromJsonFile(passwdFilePath);

        HashMap<Integer, String> indexAndPasswd = database.getIndexAndPasswd();

        ArrayList<User> userList = database.getUserList();
        if (!userList.isEmpty()) {
            for (User user : database.getUserList()) {
                System.out.println(user.getName() + user.getEmail() + user.getUserId());
            }
        }
        System.out.println(database.getUserIndexCounter());



        System.out.println("Chose an action : 1 - Log in ; 2 - Authentificate");

        int actionCode = scanner.nextInt();
        Security security = new Security();
        while (actionCode != 0) {


            if (actionCode == 1) {

                System.out.print("Email: ");
                String email = scanner.next();

                System.out.println("password: ");
                String password = scanner.next();

                boolean passedTheSecurityCheck;
                passedTheSecurityCheck = security.checkPasswordEmailMatch(email, password);


                //login to do
            } else if (actionCode == 2) {
                // authentificate
                System.out.println("Name:");
                String userName = scanner.next();

                System.out.print("Email: ");
                String email = scanner.next();

                System.out.println("password: ");
                String password = scanner.next();

                if (security.checkUniqueEmail(email)) {
                    Integer userID = security.createUniqueID();
                    indexAndPasswd.put(userID, password);
                    User user = new User(userName, email, userID);
                    userList.add(user);
                } else {
                    System.out.println("there is already this email");
                }

            } else {
                System.out.println("action invalid");
            }
            actionCode = scanner.nextInt();
        }

        scanner.close();

        userLoader.writeToJsonFile(userFilePath);
        passwdLoader.writeToJsonFile(passwdFilePath);

    }
}
