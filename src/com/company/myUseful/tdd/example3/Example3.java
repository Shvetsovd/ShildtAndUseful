package company.myUseful.tdd.example3;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Example3 {
    public static void main(String[] args) throws IOException {
        String path = "c:\\!BCP\\DMITRY\\!EBook\\MyStudyProjects\\IdeaProjects" +
                "\\ShildtAndUseful\\src\\com\\company\\myUseful\\tdd\\example3\\FileManager.java";

        System.out.println(FileManager.read(path));
    }
}
