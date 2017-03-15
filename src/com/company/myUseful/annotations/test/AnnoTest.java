package company.myUseful.annotations.test;

import company.myUseful.annotations.CODE;
import company.myUseful.annotations.CodeState;

/**
 * Created by dmitry on 24.02.17.
 */
@CodeState(CODE.DEBUG)
class AnnoTest {
    public static void main(String[] args) {

    }
    @CodeState(CODE.DEBUG)
    void meth1(){

    }

    @CodeState(CODE.RELEASE)
    void meth2(){
        System.out.println();
    }
}
