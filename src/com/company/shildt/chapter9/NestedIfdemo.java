package company.shildt.chapter9;

/**
 * Created by dmitry on 07.02.17.
 */
class A{
    public interface NestaedIf{
        boolean isNotNegative(int x);
    }
}
class B implements A.NestaedIf{

    @Override
    public boolean isNotNegative(int x) {
        return x >= 0 ? true : false;
    }
}
class NestedIfdemo {
    public static void main(String[] args) {
        A.NestaedIf nif = new B();

        if(nif.isNotNegative(10)){
            System.out.println("Число 10 неотрицательное");
        }
        if(nif.isNotNegative(-12)){
            System.out.println("Это не будет выведено");
        }
    }
}
