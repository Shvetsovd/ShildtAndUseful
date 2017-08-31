package company.useful.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by OPER on 27.06.2017.
 */
public class URLTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://google.com");

        URLConnection urlCon = url.openConnection();
        System.out.println(urlCon);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));){
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
    }
}
