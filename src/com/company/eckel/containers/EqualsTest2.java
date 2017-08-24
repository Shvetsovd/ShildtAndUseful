package company.eckel.containers;

public class EqualsTest2 {
    public static void main(String[] args) {
        Parent p1 = new Parent(10);
        Parent p2 = new Parent(10);
        System.out.println(p1.equals(p2));

        Child c1 = new Child(1,1);
        Child c2 = new Child(1,1);
        Child c3 = new Child(1,2);
        Child c4 = new Child(2,1);

        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c1.equals(c4));
    }
}

class Parent{
    private int x;

    public Parent(int x) {
        this.x = x;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)) return true;
        return obj instanceof Parent &&
                (x == ((Parent) obj).x);
    }
}
class Child extends Parent{
    private int y;

    public Child(int x, int y) {
        super(x);
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        return obj instanceof Child &&
                (y == ((Child) obj).y);
    }
}
