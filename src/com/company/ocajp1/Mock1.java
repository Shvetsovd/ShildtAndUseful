package company.ocajp1;


class SuperException extends Exception {
}

class SubException extends SuperException {
}

public class Mock1 {
    static public void main(String[] args) {

        //System.out.printf("6/45: %.10f", getChances(6, 45));
    }

    private static double getChances(int count, int total) {
        double result = 1;
        for (int i = 0; i < count; i++) {
            result *= (total - i);
        }
        return 1 / result * 100;
    }
}

interface Breakable {
    void breakAccelerate();
}

class A {
    public static void main(String[] args) {
        A a = new A();
        ((Breakable) a).breakAccelerate();
    }
}

class X {
    void m(short x) {
        System.out.println("X.m");
    }
}

class Y extends X {
    void m(int x) {
        System.out.println("Y.m");
    }
}

class Test {
    public static void main(String[] args) {
        X y = new Y();
        y.m((short) 1);
    }
}














