package company.shildt.chapter7;

/**
 * Created by OPER on 31.01.2017.
 */
class Outer{
    int outer_x = 100;
    void test(){
        Inner inner = new Inner();
        inner.display();
        inner.y = 5;
    }
    class Inner{
        int y;
        void display(){
            System.out.println("вывод: outer_x = " + outer_x);
        }
    }

    void showy(){
        //System.out.println(y);//error
    }
}
public class InnerClassDemo {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.test();
        // error outer.Inner oi = new Outer.Inner();
    }
}
