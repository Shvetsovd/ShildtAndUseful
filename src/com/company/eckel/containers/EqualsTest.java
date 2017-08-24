package company.eckel.containers;

import java.util.Objects;

/**
 * Created by user on 21.08.2017.
 */
public class EqualsTest {
    public static void main(String[] args) {
        Human p1 = new Human("Vasya", "Pupkin", 23);
        Human p2 = new Human("Vasya", "Pupkin", 23);
        System.out.println(p1.equals(p2));
    }
}

class Human {
    private static int count;
    private final int id = count++;
    private String firstName;
    private String lastName;
    private int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (o.getClass() != getClass()) return false;

        Human another = (Human) o;

        return Objects.equals(firstName, another.firstName)
                && Objects.equals(lastName, another.lastName)
                && (age == another.age);

    }


}
