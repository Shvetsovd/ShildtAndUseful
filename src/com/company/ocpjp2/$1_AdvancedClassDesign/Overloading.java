package company.ocpjp2.$1_AdvancedClassDesign;

/**
 * Created by user on 05.03.2018.
 */
public class Overloading {
    void method(int x){
        System.out.println("int");
    }

    void method(long x){
        System.out.println("int");
    }

    void method(Integer x){
        System.out.println("Integer");
    }

    void method(Object x){
        System.out.println("Object");
    }

    void method(int...x){
        System.out.println("vararg");
    }

    //compile error (array eq. vararg)
    /*void method(int[] x){
        System.out.println("array");
    }*/

    public static void main(String[] args) {
        new Overloading().method(0);
    }
}

