package company.eckel.initialization;

public class Test {
    int a = 5;

    public Test() {
        this.a = 10;
    }

    {
        a = 20;
    }

    public static void main(String[] args) {
        Test obj = new Test();
        System.out.println(obj.a);
    }
}
