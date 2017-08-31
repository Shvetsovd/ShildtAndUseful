package company.useful.tdd.example1;

public class FordFactory implements CarFactory {
    @Override
    public Car getCar() {
        System.out.println("Create new Ford car...");
        return new Car("Ford", "Focus");
    }
}
