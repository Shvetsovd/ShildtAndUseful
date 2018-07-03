package company.ocpjp2.$9_NIO2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

/**
 * Created by user on 28.05.2018.
 */
public class PathTest {
    public static void main(String[] args) {
        Path p = Paths.get("!");
        System.out.println(">" + p.getFileName() + "<");
    }
}
