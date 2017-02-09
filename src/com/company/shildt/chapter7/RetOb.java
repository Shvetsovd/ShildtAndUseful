package company.shildt.chapter7;

/**
 * Created by dmitry on 31.01.17.
 */
class Test3{
    int a;

    public Test3(int a) {
        this.a = a;
    }

    Test3 incrByTen(){
        Test3 temp = new Test3(a + 10);
        return temp;
    }
}
class RetOb {
    public static void main(String[] args) {
        Test3 ob1 = new Test3(2);
        Test3 ob2;

        ob2 = ob1.incrByTen();
        System.out.println("ob1.a:" + ob1.a);
        System.out.println("ob2.a:" + ob2.a);

        ob2 = ob2.incrByTen();
        System.out.println("ob2.a после второго увеличения значения: "
                            + ob2.a);

    }
}
