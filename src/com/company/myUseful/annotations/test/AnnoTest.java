package company.myUseful.annotations.test;

import company.myUseful.annotations.CODE;
import company.myUseful.annotations.devstatus;

/**
 * Created by dmitry on 24.02.17.
 */
@devstatus(CODE.DEBUG)
public class AnnoTest {
    public static void main(String[] args) {

    }
    @devstatus(CODE.DEBUG)
    void meth1(){

    }

    @devstatus(CODE.RELEASE)
    void meth2(){
        System.out.println();
    }
}
