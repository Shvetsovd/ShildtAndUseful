package company.shildt.chapter13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by OPER on 10.03.2017.
 */
public class BReaderFile {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));

        BufferedReader br = new BufferedReader(new
                InputStreamReader(new
                FileInputStream(".gitignore")));

        String str;

        while (true){
            str = br.readLine();
            if(str == null) break;
            System.out.println(str);
        }

        br.close();
    }
}
