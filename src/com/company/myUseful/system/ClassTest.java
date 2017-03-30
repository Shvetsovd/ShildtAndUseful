package company.myUseful.system;

/**
 * Created by OPER on 30.03.2017.
 */
public class ClassTest {
    public static void main(String[] args) {
        Class<?> clazz = ClassTest.class.getClass();
        System.out.println(clazz + "\n");
        System.out.println(clazz.getSuperclass() + "\n");
        System.out.println(clazz.getClassLoader() + "\n");
        System.out.println(clazz.getProtectionDomain() + "\n");
    }
}
