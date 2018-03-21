package company.ocpjp2.$1_AdvancedClassDesign;

import java.util.Objects;

/**
 * Created by user on 07.03.2018.
 */

class Cat {
    private int id;
    private String name;
    private int age;
    private int weight;

    public Cat(int id, String name, int age, int weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cat)) return false;
        Cat anotherCat = (Cat) o;

        return Objects.equals(this.id, anotherCat.id)
                && Objects.equals(this.name, anotherCat.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);

        return result;
    }
}

public class ToString {
    public static void main(String[] args) {
        System.out.println(new String[0]); // [Ljava.lang.String;@14ae5a5
        System.out.println(new String[0][]); // [[Ljava.lang.String;@7f31245a

        Cat cat = new Cat(1, "Tom", 5, 7);
        System.out.println(cat);  // Cat{id=1, name='Tom', age=5, weight=7}

        System.out.println(new Cat[]{cat}); // [Lcompany.ocpjp2.$1_AdvancedClassDesign.Cat;@6d6f6e28

    }
}
