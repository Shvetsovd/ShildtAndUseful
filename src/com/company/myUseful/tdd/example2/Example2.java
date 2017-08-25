package company.myUseful.tdd.example2;

import java.io.ByteArrayOutputStream;

public class Example2 {
    public static void main(String[] args) {
        Printer printer = new BufferedPrinter(new ConsolePrinter());
        printer.print("Hello");
    }

}
