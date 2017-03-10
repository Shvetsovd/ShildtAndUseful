/**
 * Created by dmitry on 10.03.17.
 */
public class NativeDemo {
    int i;

    public static void main(String[] args) {
        NativeDemo ob = new NativeDemo();
        ob.i = 10;

        System.out.println("Содержимое ob.i перед вызовом платформенно-ориентированного метода: " + ob.i);

        ob.test();

        System.out.println("Содержимое ob.i после вызова платформенно-ориентированного метода: " + ob.i);
    }

    public native void test();

    static {
        System.loadLibrary("NativeDemo");
    }
}
