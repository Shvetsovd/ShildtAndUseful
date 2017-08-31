package company.useful.serialize;

import java.io.Serializable;

/**
 * Created by user on 26.06.2017.
 */
public class A implements Serializable{
    int a;
    int arr[];
    float b;
    final String s = "Hello";

    public A() {
    }

    public A(int a, int[] arr, float b) {
        this.a = a;
        this.arr = arr;
        this.b = b;
    }

    void incr(){
        a++;
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
        b++;
    }
    void showFields(){


    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.getClass().getName() + "\n");
        str.append("a = " + a + "\n");
        str.append("arr[] = ");

        for (int i : arr) {
            str.append(i + " ");
        }

        str.append("\nb = " + b);

        return str.toString();
    }
}

class B extends A{

    public B() {
    }

    public B(int a, int[] arr, float b) {
        super(a, arr, b);
    }
}
