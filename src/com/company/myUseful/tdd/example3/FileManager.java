package company.myUseful.tdd.example3;

import company.eckel.net.mindview.util.RandomGenerator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    public static String read(String path) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String s;
            while ((s = reader.readLine()) != null) {
               result.append(s + "\n");
            }
        }
        return result.toString();
    }
}
