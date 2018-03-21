package company.ocpjp2.$2_DesignPatternsAndPrinciples;

/**
 * Created by user on 10.03.2018.
 */
class Animal1{}
class Kangaroo extends Animal1{}

interface Run extends Sprint {}


interface SprintFaster extends Sprint {
    void sprint(Animal1 animal);
}

interface Skip extends Sprint {
    public default int getHopCount(Kangaroo kangaroo) {return 10;}
    public static void skip(int speed) {}
}

@FunctionalInterface
interface Sprint {
    public void sprint(Animal1 animal);
}

interface Walk {}

interface Dance extends Sprint {
    public void dance(Animal1 animal);
}

interface Crawl {
    public void crawl();
    public int getCount();
}
public class FunctionalInterfaces {
}
