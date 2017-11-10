package company.ocajp1;


class SuperException extends Exception {
}

class SubException extends SuperException {
}

public class Mock1 {
    static public void main(String[] args) {

        System.out.printf("6/45: %.10f", getChances(6, 45));

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














