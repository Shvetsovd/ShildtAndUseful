package company.ocpjp2.$3_Generics_and_Collections;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by user on 29.03.2018.
 */
public class ArraysTest {
    public static void main(String[] args) {
        //sortTest();
        binarySearchTest();

    }

    private static void binarySearchTest() {
        int[] a = {10, 5, 8, 12, 1, 6};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a)); //[1, 5, 6, 8, 10, 12]
        System.out.println(Arrays.binarySearch(a, 6)); //2
        System.out.println(Arrays.binarySearch(a, 3)); //-2

        String[] strs = {"B", "c", "A", "d"};
        System.out.println(Arrays.binarySearch(strs, "d"));//Undefined
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs)); //[A, B, c, d]
        System.out.println(Arrays.binarySearch(strs, "d")); //3
        System.out.println(Arrays.binarySearch(strs, "D")); //-3
    }

    private static void sortTest() {
        class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }
        Person[] persons = {new Person("Mike", 25), new Person("Kate", 30)};
        //Arrays.sort(persons); //ClassCastException
        Arrays.sort(persons, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        System.out.println(Arrays.toString(persons));
        //[Person{name='Kate', age=30}, Person{name='Mike', age=25}]

        Arrays.sort(persons, (p1, p2) ->
                Comparator.<Person, String>comparing(p -> p.getName())
                        .thenComparingInt(p -> p.getAge())
                        .compare(p1, p2));

        Integer a[] = {1, 2, 3};
        Arrays.sort(a, Comparator.reverseOrder());
        System.out.println(Arrays.toString(a)); //[3, 2, 1]
    }
}
