package company.useful.net;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by OPER on 27.06.2017.
 */
public class httpURLConnection {
    public static void main(String[] args) throws IOException {
        HttpURLConnection conn = (HttpURLConnection)
                new URL("http://www.google.com").openConnection();

        System.out.println("Метод запроса: " + conn.getRequestMethod());
        System.out.println("Код ответа: " + conn.getResponseCode());
        System.out.println("Ответное сообщение: " + conn.getResponseMessage());

        Map<String, List<String>> headerFields = conn.getHeaderFields();
        Set<String> keys = headerFields.keySet();
        for (String key : keys) {
            System.out.println("Ключ: " + key + " Значение: " + headerFields.get(key));
        }
    }
}
