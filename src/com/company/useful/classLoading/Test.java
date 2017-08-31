package company.useful.classLoading;

/**
 * Created by OPER on 09.06.2017.
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader cl = new MyClassLoader();
        Class<?> clazz = Class.forName("company.useful.basicalgorithms.arrays.BinarySearch", true, cl);
        System.out.println(clazz.getClassLoader().getClass().getName());
    }
}
