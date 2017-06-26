package company.myUseful.serialize;


import java.io.*;

/**
 * Created by user on 26.06.2017.
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        A obj = new B(0, new int[10], 0);
        obj.incr();

        System.out.println(obj);

        serialize(obj);

        obj = null;

        obj = deserialize();

        System.out.println(obj);

    }

    private static <T> T deserialize() throws IOException, ClassNotFoundException {
        T obj;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/A.txt"));){
            return (T) in.readObject();
        }
    }

    private static <T> void serialize(T obj) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:/A.txt"));){
            out.writeObject(obj);
        }
    }
}
