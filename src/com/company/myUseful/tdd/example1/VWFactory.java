package company.myUseful.tdd.example1;

public class VWFactory implements CarFactory {
    @Override
    public Car getCar() {
        System.out.println("Create new VW car...");
        return new Car("VW", "Passat");
    }
}
