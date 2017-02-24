package company.myUseful.annotations.test;

import company.myUseful.annotations.CODE;
import company.myUseful.annotations.Devstatus;

/**
 * Created by dmitry on 24.02.17.
 */
@Devstatus(CODE.DEBUG)
class AnnoTest {
    public static void main(String[] args) {

    }
    @Devstatus(CODE.DEBUG)
    void meth1(){

    }

    @Devstatus(CODE.RELEASE)
    void meth2(){
        System.out.println();
    }
}
