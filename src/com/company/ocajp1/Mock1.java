package company.ocajp1;

import java.io.IOException;

final public class Mock1 extends Mock {
    public static void main(String[] args) {
    }
}

class Capybara {
    String s;
    public static void main(String[] args) {

        Capybara obj = new Capybara();
        obj.s += 15E3;
        obj.s += null;
        System.out.println(obj.s); //null15000.0null

    }
}




