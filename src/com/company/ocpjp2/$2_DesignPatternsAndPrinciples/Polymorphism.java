package company.ocpjp2.$2_DesignPatternsAndPrinciples;

/**
 * Created by user on 11.03.2018.
 */
public class Polymorphism {
}

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Plane implements Flyable {
    public void fly() {
        System.out.println("Plane is flying");
    }
}

class FlyDirector {
    public void startFly(Flyable f) {
        f.fly();
    }

    public void main(String[] args) {
        FlyDirector fd = new FlyDirector();
        fd.startFly(new Bird());
        fd.startFly(new Plane());
    }
}