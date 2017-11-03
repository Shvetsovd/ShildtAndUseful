package company.ocajp1;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

final public class Mock1 {
    static public void main(String[] args) throws Exception {
        Duration dur = Duration.ofHours(7);

        System.out.println(dur);
        /*DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(f.format(date1));*/
    }

}

interface Intf{
    default void m(){}
}
class A{}
class B extends A{
    public void m(){}
}
class C extends B implements Intf{
    void method(){
        Intf.super.m();
    }
}
class D extends C{}













