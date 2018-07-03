package company.my.sbertech;

/* Java */

import java.util.*;

public class FSUtilities {

    public static List<File> findAllFilesByName(Folder folder, String fName) {
        List<File> result = new ArrayList<>();
        findR(folder, fName, result);
        return result;
    }

    private static void findR(Folder folder, String fName, List<File> result) {
        for (File f : folder.getFiles()) {
            if (f != null && f.getName().equals(fName)) {
                result.add(f);
            }
        }
        for (Folder fldr : folder.getSubFolders()) {
            if (fldr != null) {
                findR(fldr, fName, result);
            }
        }
    }
}

/* mock */
class Folder {
    public Folder[] getSubFolders() {
        return new Folder[0];
    }

    public List<File> getFiles() {
        return new ArrayList<>();
    }
}
/* mock */
class File {
    public String getName() {
        return "";
    }
}
