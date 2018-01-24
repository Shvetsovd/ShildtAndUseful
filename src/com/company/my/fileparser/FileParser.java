package company.my.fileparser;

import java.io.*;

/**
 * Created by user on 24.01.2018.
 */
public class FileParser {
    private File file;

    public FileParser(File file) {
        this.file = file;
    }

    public int patternLineCount(String regexPattern) {
        int result = 0;
        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while ((line = br.readLine()) != null){
                if (line.matches(regexPattern)){
                    result++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        FileParser fp = new FileParser(new File("C:/Phones.txt"));
        System.out.println("Количество строк с цифрами: " + fp.patternLineCount(".*[\\d].*"));
        System.out.println("Количество строк с 6 и более цифрами подряд: " + fp.patternLineCount(".*([\\d]{6,}).*") + "\n");
        System.out.println("Количество пустых строк: " + fp.patternLineCount("\\s*"));
        System.out.println("Количество непустых строк: " + fp.patternLineCount(".*[^\\s*].*"));
        System.out.println("Общее количество строк: " + fp.patternLineCount(".*"));


    }
}
