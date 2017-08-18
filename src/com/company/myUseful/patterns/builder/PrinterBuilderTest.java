package company.myUseful.patterns.builder;

import company.eckel.net.mindview.util.Print;

public class PrinterBuilderTest {
    public static void main(String[] args) {
        PrinterDirector director = new PrinterDirector();

        director.setBuilder(new EpsonPrinterBuilder());
        Printer epson = director.buildPrinter();

        director.setBuilder(new CanonPrinterBuilder());
        Printer canon = director.buildPrinter();

        System.out.println(epson);
        System.out.println(canon);
    }
}

enum PrintingTechnology {LASER, INKJET};

class Printer {
    private String vendor;
    private String modelName;
    private PrintingTechnology type;

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setType(PrintingTechnology type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "vendor='" + vendor + '\'' +
                ", modelName='" + modelName + '\'' +
                ", type=" + type +
                '}';
    }
}

abstract class PrinterBuilder {
    protected Printer printer;

    void createPrinter() {
        printer = new Printer();
    }

    abstract void buildVendor();

    abstract void buildModelName();

    abstract void buildType();

    public Printer getPrinter() {
        return printer;
    }
}

class EpsonPrinterBuilder extends PrinterBuilder {

    @Override
    void buildVendor() {
        printer.setVendor("Epson");
    }

    @Override
    void buildModelName() {
        printer.setModelName("1410");
    }

    @Override
    void buildType() {
        printer.setType(PrintingTechnology.INKJET);
    }
}

class CanonPrinterBuilder extends PrinterBuilder {

    @Override
    void buildVendor() {
        printer.setVendor("Canon");
    }

    @Override
    void buildModelName() {
        printer.setModelName("7100");
    }

    @Override
    void buildType() {
        printer.setType(PrintingTechnology.LASER);
    }
}

class PrinterDirector{
    PrinterBuilder builder;

    public void setBuilder(PrinterBuilder builder) {
        this.builder = builder;
    }
    Printer buildPrinter(){
        builder.createPrinter();

        builder.buildVendor();
        builder.buildModelName();
        builder.buildType();

        return builder.getPrinter();
    }
}