package company.myUseful.reflection;

import java.io.BufferedReader;
import java.io.FileFilter;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.*;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by user on 06.04.2017.
 */
public class ReflectionClassParser_Test {
    public static void main(String[] args) {
        Class<?> className = StringTokenizer.class;

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
