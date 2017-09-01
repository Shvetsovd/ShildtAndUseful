package company.useful.equals;

import java.util.Objects;

public class Parent {
    int x;
    Object parentField;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parent)) return false;

        Parent other = (Parent) o;
        return Objects.equals(this.x, other.x)
                && Objects.equals(this.parentField, other.parentField);
    }
}

class Child extends Parent {
    int y;
    Object childField;

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Child)) return false;

        Child other = (Child) o;
        return Objects.equals(this.y, other.y)
                && Objects.equals(this.childField, other.childField);

    }
}

class Test {
    public static void main(String[] args) {
        Parent ob1 = new Child();
        Parent ob2 = new Child();
        System.out.println(ob1.equals(ob2));
    }
}



