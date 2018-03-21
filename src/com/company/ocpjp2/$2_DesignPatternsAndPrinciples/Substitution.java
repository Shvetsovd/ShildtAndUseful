package company.ocpjp2.$2_DesignPatternsAndPrinciples;

/**
 * Created by user on 11.03.2018.
 */
public class Substitution {
}

class Rodent {}

class Capybara extends Rodent {
    public static void main(String[] args) {
        Rodent rodent = new Rodent();
        Capybara capybara = new Capybara();

        rodent = capybara; //OK
        //capybara = rodent; //COMPILE ERROR

        capybara = (Capybara) rodent; // OK

        rodent = new Rodent();
        capybara = (Capybara) rodent; // Throws ClassCastException at runtime

        //String s = (String) capybara; //COMPILE ERROR
        Runnable r = (Runnable) capybara; // Throws ClassCastException at runtime
    }
}
