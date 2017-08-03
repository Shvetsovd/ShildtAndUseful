package company.eckel.chapter2objects;

public class Task4$DataOnly {
    public static void main(String[] args) {
        DataOnly obj = new DataOnly();

        System.out.println(obj.i);
        System.out.println(obj.d);
        System.out.println(obj.b);
    }
}

class DataOnly{
    int i = 10;
    double d = 20;
    boolean b = true;
}
