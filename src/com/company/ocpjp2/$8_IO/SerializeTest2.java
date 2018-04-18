package company.ocpjp2.$8_IO;

import java.io.*;

/**
 * Created by user on 19.04.2018.
 */
public class SerializeTest2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Child c1 = new Child(10, 20);
        System.out.println(c1);

        //Serialize
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bout);
        out.writeObject(c1);
        out.flush();
        out.close();

        //Deserialize
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        Child c2 = (Child) in.readObject();
        System.out.println(c2);
        in.close();

    }
}

class Parent {
    private int a = 200;
    {a = 300;}
    public Parent() {
        a = 400;
    }

    public Parent(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "a=" + a +
                '}';
    }
}

class Child extends Parent implements Serializable {
    private static final long serialVersionUID = 1L;
    private int b;


    public Child(int a, int b) {
        super(a);
        this.b = b;
    }

    @Override
    public String toString() {
        return "Child{" +
                super.toString() +
                "b=" + b +
                '}';
    }
}
