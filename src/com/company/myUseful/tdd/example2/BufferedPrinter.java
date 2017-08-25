package company.myUseful.tdd.example2;

public class BufferedPrinter implements Printer {
    Printer printer;

    public BufferedPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String msg) {
        System.out.println(" - Buffering - ");
        printer.print(msg);
    }
}
