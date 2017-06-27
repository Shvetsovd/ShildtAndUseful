package company.myUseful.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user on 07.04.2017.
 */
public class GetURLContent {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://lenta.ru");
        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));

        String data = bf.readLine();
        while (data != null){
            System.out.println(data);
            data = bf.readLine();
        }
    }
}
