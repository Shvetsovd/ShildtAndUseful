package company.useful.tdd.example1;

public class Example1 {
    public static void main(String[] args) {
        CarFactory factory;

        factory = new FordFactory();
        Car car1 = factory.getCar();

        factory = new VWFactory();
        Car car2 = factory.getCar();

        System.out.println(car1);
        System.out.println(car2);

    }
}
