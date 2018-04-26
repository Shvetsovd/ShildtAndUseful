package company.ocpjp2.$8_IO;

import java.io.*;

/**
 * Created by user on 18.04.2018.
 */

public class SerializeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String serPath = "E:/foo/baz/person_ser.txt";
        Person p1 = new Person("Petya", "Ivanov", 20);
        try(ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(serPath)));) {
            out.writeObject(p1);
        }
        Person p2;
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(serPath)))){
            p2 = (Person) in.readObject();
        }
        System.out.println("p1 = " + p1); // p1 = Person{fName='Petya', lName='Ivanov', age=20}
        System.out.println("p2 = " + p2); // p2 = Person{fName='Petya', lName='Ivanov', age=20}
        System.out.println("p2.setAge(35);");
        p2.setAge(35);
        System.out.println("p1 = " + p1); // p1 = Person{fName='Petya', lName='Ivanov', age=20}
        System.out.println("p2 = " + p2); // p2 = Person{fName='Petya', lName='Ivanov', age=35}
    }
}

class Person implements Serializable{
    private String fName;
    private String lName;
    private int age;

    public Person(String fName, String lName, int age) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public int getAge() {
        return age;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                '}';
    }
}
