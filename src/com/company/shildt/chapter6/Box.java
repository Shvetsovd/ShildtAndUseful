package company.shildt.chapter6;

/**
 * Created by OPER on 19.01.2017.
 */
public class Box {
    double width;
    double height;
    double depth;

    Box() {
    }

    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    double volume() {
        return width * height * depth;
    }

    void setDim(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.width = 0;
        this.height = 0;
        this.depth = 0;
        System.out.println("Сборка мусора!");
    }
}
