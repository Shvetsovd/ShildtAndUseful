package company.useful.reflection;

import java.util.zip.ZipOutputStream;

/**
 * Created by user on 06.04.2017.
 */
public class ReflectionClassParser_Test {
    public static void main(String[] args) {
        Class<?> className = ZipOutputStream.class;

        printInheritInfo(className);
        printClassInfo(className);
    }

    private static void printInheritInfo(Class<?> className) {
        String[] inheritInfo = ReflectionClassParser.getInheritSequence(className);

        for (int i = 0; i < inheritInfo.length - 1; i++) {
            System.out.print(inheritInfo[i] + " -->  ");
        }
        System.out.print(inheritInfo[inheritInfo.length - 1] + "\n\n");
    }

    private static void printClassInfo(Class<?> className) {
        String[] info = ReflectionClassParser.parse(className);

        for (String s : info) {
            System.out.println(s);
        }
    }
}
