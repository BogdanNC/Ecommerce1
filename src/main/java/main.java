import netscape.javascript.JSObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<User> userList = new ArrayList<>();


        System.out.println("Chose an action : 1 - Log in ; 2 - Authentificate");
        int actionCode = scanner.nextInt();

        if (actionCode == 1 ){
            //login to do
        } else if (actionCode == 2) {
            // authentificate
            System.out.println("Name:");
            String userName = scanner.next();

            System.out.print("Email: ");
            String email = scanner.next();

            System.out.println("userID: ");
            Integer userID = scanner.nextInt();

            User user = new User(userName, email, userID);
            userList.add(user);
        } else {
            System.out.println("action invalid");
        }

        scanner.close();

       // Gson database = new Gson();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File("users.json"), userList);
            System.out.println("user info stored in users.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
