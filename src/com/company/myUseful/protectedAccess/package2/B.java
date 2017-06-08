package company.myUseful.protectedAccess.package2;

import company.myUseful.protectedAccess.package1.A;

/**
 * Created by OPER on 08.06.2017.
 */
public class B extends A {
    void method(B b){
        b.x = 20;
    }
}

class C extends B{

}
