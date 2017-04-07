package company.myUseful.reflection;

import java.io.BufferedReader;
import java.io.FileFilter;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by user on 06.04.2017.
 */
public class ReflectionClassParser_Test {
    public static void main(String[] args) {
        String[] info = ReflectionClassParser.parse(HashSet.class);
        for (String s : info) {
            System.out.println(s);
        }
    }
}
