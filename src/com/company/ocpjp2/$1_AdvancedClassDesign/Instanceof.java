package company.ocpjp2.$1_AdvancedClassDesign;

/**
 * Created by user on 05.03.2018.
 */
class HeavyAnimal { }
class Hippo extends HeavyAnimal { }
class Elephant extends HeavyAnimal { }

public class Instanceof {
    public static void main(String[] args) {
        HeavyAnimal animal = new Hippo();
        boolean b1 = animal instanceof Hippo; // true
        boolean b2 = animal instanceof HeavyAnimal; // true
        boolean b3 = animal instanceof Elephant; // false
        boolean b4 = animal instanceof Object; // true

        Hippo hippo = new Hippo();
        boolean b5 = hippo instanceof Hippo; // true
        boolean b6 = hippo instanceof HeavyAnimal; // true
        //boolean b7 = hippo instanceof Elephant; // COMPILE ERROR
        boolean b8 = (HeavyAnimal)hippo instanceof Elephant; // false


        Runnable r = new Thread();
        boolean b9 = hippo instanceof Runnable; // false
        boolean b10 = r instanceof Hippo; // false

        hippo = null;
        boolean b11 = hippo instanceof Hippo; // false
        boolean b12 = null instanceof Hippo; // false
    }
}
