package company.shildt.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by OPER on 10.03.2017.
 */
public class CopyFile2 {
    public static void main(String[] args) {
        try (FileInputStream fin = new FileInputStream("test1");
             FileOutputStream fout = new FileOutputStream("test2")) {

            int i;
            do {
                i = fin.read();
                if (i != -1) {
                    fout.write(i);
                }
            } while (i != -1);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
}
