package company.useful.tdd.example2;

public class Example2 {
    public static void main(String[] args) {
        Printer printer = new BufferedPrinter(new ConsolePrinter());
        printer.print("Hello");
    }

}
