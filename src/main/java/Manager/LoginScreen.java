package Manager;

import Database.Database;
import UserPack.Security;
import UserPack.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LoginScreen {
    private Database database = Database.getDatabase();
    public void loadLoginScreen (int actionCode) {

        Scanner scanner = new Scanner(System.in);

        Security security = new Security();
        HashMap<Integer, String> indexAndPasswd = database.getIndexAndPasswd();

        ArrayList<User> userList = database.getUserList();
        if (!userList.isEmpty()) {
            for (User user : database.getUserList()) {
                System.out.println(user.getName() + user.getEmail() + user.getUserId());
            }
        }// it's just an output

        System.out.println(database.getUserIndexCounter());


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
                System.out.println("authentification succesfull");
            } else {
                System.out.println("there is already this email");
            }

        } else {
            System.out.println("action invalid");
        }


    }
}
