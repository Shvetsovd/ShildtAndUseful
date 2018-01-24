package company.ocajp1.override.b;

import company.ocajp1.override.a.A;

/**
 * Created by user on 19.01.2018.
 */
public class B extends A {
    @Override
    public void mPublic() {
        System.out.println("B.mPublic");
    }
    private void mPrivate(){
        System.out.println("B.mPrivate");
    }
    void mDefault(){
        System.out.println("B.mDefault");
    }
}
class Test{
    public static void main(String[] args) {
        B b = new B();
        b.mDefault();
    }
}
