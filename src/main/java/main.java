import DataManipulations.PasswdLoader;
import DataManipulations.ProductsLoader;
import DataManipulations.UserLoader;
import Database.Database;
import Manager.LoginScreen;
import Manager.ProductManager;
import java.util.Scanner;
import Classes.Money;
public class main {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        Database database = Database.getDatabase();

        UserLoader userLoader = new UserLoader();
        PasswdLoader passwdLoader = new PasswdLoader();
        ProductsLoader productsLoader = new ProductsLoader();

        String userFilePath = "users.json";
        String passwdFilePath = "passwd.json";
        String productsFilePath = "products.json";

        userLoader.loadFromJsonFile(userFilePath);
        passwdLoader.loadFromJsonFile(passwdFilePath);

        LoginScreen loginScreen = new LoginScreen();
        ProductManager productManager = new ProductManager();

        System.out.println("Chose an action : 1 - Log in ; 2 - Authentificate");
        int actionCode = scanner.nextInt();
        while (actionCode != 0) {
            if (actionCode <= 2 && actionCode >= 1) {
                loginScreen.loadLoginScreen(actionCode);
            }
            if (actionCode == 10) {
                Money money = new Money(10.00, "USD");
                System.out.println(money.value);
                System.out.println(money.currencyCode);
                System.out.println(money.addPercent("5"));
                System.out.println(money.subtractPercentage(5));
                System.out.println(money.subtractTax(5.00));
            }

            System.out.println("Chose an action : 1 - Log in ; 2 - Authentificate");
            actionCode = scanner.nextInt();
        }
        scanner.close();
        userLoader.writeToJsonFile(userFilePath);
        passwdLoader.writeToJsonFile(passwdFilePath);
        productsLoader.writeToJsonFile(productsFilePath);

    }
}
