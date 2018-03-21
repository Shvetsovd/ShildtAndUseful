package company.ocpjp2.$1_AdvancedClassDesign;

/**
 * Created by user on 05.03.2018.
 */
/*
//Instanceof
class Animal{
    public void feedAnimal(Animal animal) {
        if(animal instanceof Cow) {
            ((Cow)animal).addHay();
        } else if(animal instanceof Bird) {
            ((Bird)animal).addSeed();
        } else if(animal instanceof Lion) {
            ((Lion)animal).addMeat();
        } else {
            throw new RuntimeException("Unsupported animal");
        } }
}
class Bird extends Animal{
    public void addSeed() {}
}
class Cow extends Animal{
    public void addHay() {}
}
class Lion extends Animal{
    public void addMeat() {}
}*/

//VMI
abstract class Animal{
    public abstract  void feed();
    public void feedAnimal(Animal animal) {
        animal.feed();
    }
}
class Bird extends Animal{
    @Override
    public void feed() {
        addSeed();
    }
    private void addSeed() {}

}
class Cow extends Animal{
    @Override
    public void feed() {
        addHay();
    }
    private void addHay() {}
}
class Lion extends Animal{
    @Override
    public void feed() {
        addMeat();
    }
    private void addMeat() {}
}
public class InstanceofVSvmi {
}
