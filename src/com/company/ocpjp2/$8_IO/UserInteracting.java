package company.ocpjp2.$8_IO;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by user on 27.04.2018.
 */
public class UserInteracting {
    public static void main(String[] args) throws IOException {
        oldWay();
        newWay();
    }

    private static void oldWay() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();
        System.out.println("You entered: " + s);
    }

    private static void newWay() throws IOException {
        Console con = System.console(); //Singleton
        if (con != null){
            while (true) {
                con.printf("Enter your name: ");
                // recommend call flush() for console before input operations
                con.flush();

                String name = con.readLine();

                con.format("Hello, %s", name);
                con.flush();

                String login = con.readLine("login: ");
                char[] pass = con.readPassword("Password: ");
                char[] pass1 = con.readPassword("Confirm password: ");
                if (Arrays.equals(pass, pass1)) {
                    con.printf("login = %s, your password accepted", login);
                } else {
                    con.printf("login = %s, your password NOT accepted", login);
                }
                con.flush();
                Arrays.fill(pass, 'x');
                Arrays.fill(pass1, 'x');

                con.writer().println("Exit? (Y / AnyKey): "); // PrintWriter
                char choice = (char) con.reader().read(); // Reader
                if (choice == 'Y' || choice == 'y'){
                    break;
                }
            }
        }
    }
}
