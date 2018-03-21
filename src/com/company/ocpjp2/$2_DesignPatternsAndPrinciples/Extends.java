package company.ocpjp2.$2_DesignPatternsAndPrinciples;

/**
 * Created by user on 11.03.2018.
 */
interface Pet{}
abstract class Animal2{}
abstract class Feline extends Animal2{}
class Cat extends Feline implements Pet{}
class Tiger extends Feline{}
class Dog extends Animal2 implements Pet{}

public class Extends {
}
