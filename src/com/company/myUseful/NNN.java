package company.myUseful;

import java.io.*;
import java.util.stream.Stream;

/**
 * Created by Dmitry on 26.06.2017.
 */
class Parent {

    void m(int a) {
        System.out.println("Parent.m()");
    }
}

class Child extends Parent {

    void m(long a) {
        System.out.println("Child.m()");
    }
}

public class NNN {
    public static void main(String[] args) throws IOException {
        //byte a = 0;

        Parent obj = new Child();
        obj.m(0);

    }
}








