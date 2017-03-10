package company.shildt.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by OPER on 10.03.2017.
 */
public class BRRead {
    public static void main(String[] args) throws IOException {
        char c;
        BufferedReader br= new BufferedReader(new
                InputStreamReader(System.in));

        System.out.println("Введите символы, 'q' - для выхода");

        do{
            c = (char) br.read();
            System.out.println(c);

        }while (c != 'q');
    }
}
