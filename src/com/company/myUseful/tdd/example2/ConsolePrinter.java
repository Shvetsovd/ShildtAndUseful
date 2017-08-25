package company.myUseful.tdd.example2;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String msg) {
        System.out.println(" - Print in console - ");
        System.out.println(msg);
    }
}
