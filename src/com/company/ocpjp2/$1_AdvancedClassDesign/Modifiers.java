package company.ocpjp2.$1_AdvancedClassDesign;

/**
 * Created by user on 05.03.2018.
 */
public class Modifiers {
    private int x;
    public static void pubMethod(){
        privMethod();
    }
    private static void privMethod(){
        System.out.println(new Modifiers().x);
    }
}
class Test{
    public static void main(String[] args) {
        //Modifiers.privMethod(); //compile error
        Modifiers.pubMethod(); //ok, print 0;
    }
}
