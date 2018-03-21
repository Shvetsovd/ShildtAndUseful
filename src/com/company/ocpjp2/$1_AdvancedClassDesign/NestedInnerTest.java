package company.ocpjp2.$1_AdvancedClassDesign;

/**
 * Created by user on 09.03.2018.
 */

class Outer3 {
    public class MemberInner {
    }

    void m1() {
        class Local {
        }
    }

    void m2() {
        Runnable anon = new Runnable() {
            @Override
            public void run() {

            }
        };
        Runnable anon2 = () -> {
        };
    }
}

class Outer4 {
    private int x = 5;

    void m() {
        int y;
        if (3 > 2) {
            y = 3;
        } else {
            y = 2;
        }

        Runnable anon2 = () -> {
            System.out.println(x); // 6
            System.out.println(y); // 3
            //System.out.println(++y); // COMPILE ERROR
        };
    }
}

public class NestedInnerTest {
    public static void main(String[] args) {

        Outer3.MemberInner inner1 = new Outer3().new MemberInner();

        Outer3 outObj = new Outer3();
        Outer3.MemberInner inner2 = outObj.new MemberInner();

    }
}
