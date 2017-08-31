package company.useful.system;

public class SystemProperties {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println();
        System.out.println(System.getProperty("java.library.path"));
    }
}
