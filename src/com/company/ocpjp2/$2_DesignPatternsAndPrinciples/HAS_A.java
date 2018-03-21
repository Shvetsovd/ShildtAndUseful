package company.ocpjp2.$2_DesignPatternsAndPrinciples;

/**
 * Created by user on 11.03.2018.
 */
class Flippers {
    public void flap() {System.out.println("The flippers flap back and forth");}
}

class WebbedFeet {
    public void kick() {System.out.println("The webbed feet kick to and fro");}
}

class Penguin {
    private final Flippers flippers;
    private final WebbedFeet webbedFeet;

    public Penguin() {
        this.flippers = new Flippers();
        this.webbedFeet = new WebbedFeet();
    }

    public void flap() {
        this.flippers.flap();
    }

    public void kick() {
        this.webbedFeet.kick();
    }
}

public class HAS_A {
}
