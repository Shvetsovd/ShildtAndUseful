package company.myUseful.net;

import java.io.*;
import java.net.Socket;

/**
 * Created by OPER on 27.06.2017.
 */
public class WhoIsTest {
    public static void main(String[] args) throws IOException {

       whoIs("yandex.ru");
    }
    static void whoIs(String query) throws IOException {

        Socket whois = new Socket("whois.nic.ru", 43);

        try(BufferedReader in = new BufferedReader(new InputStreamReader(whois.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(whois.getOutputStream()));) {

            out.write(query + "\n");
            out.flush();

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
