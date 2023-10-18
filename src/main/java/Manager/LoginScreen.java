package Manager;

import Manager.AccountManager;
import java.util.Scanner;

public class LoginScreen {
    private AccountManager accountManager = new AccountManager();
    public void loadLoginScreen (int actionCode) {
        Scanner scanner = new Scanner(System.in);

        if (actionCode == 1) {

            System.out.print("Email: ");
            String email = scanner.next();

            System.out.println("password: ");
            String password = scanner.next();

            Boolean success = accountManager.login(email, password);


            //login to do
        } else if (actionCode == 2) {
            // authentificate
            System.out.println("Name:");
            String username = scanner.next();

            System.out.print("Email: ");
            String email = scanner.next();

            System.out.println("password: ");
            String password = scanner.next();

            try {
                String userCookie = accountManager.createAccount(username, email, password);
            } catch (Exception err) {
                System.out.println(err.getMessage());
            }
        } else {
            System.out.println("action invalid");
        }


    }
}
