package company.shildt.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by OPER on 10.03.2017.
 */
public class ShowFile2 {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("test1");
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    System.out.println("Ошибка закрытия файла");
                }
            }
        }

    }
}
