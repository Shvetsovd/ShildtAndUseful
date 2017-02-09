package company.shildt.chapter8;

import java.lang.*;
import java.lang.Override;

/**
 * Created by OPER on 06.02.2017.
 */
public class FindAreas {
    public static void main(String[] args) {
        Figure figref;
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);

        figref = r;
        System.out.println(figref.area());

        figref = t;
        System.out.println(figref.area());
    }
}

abstract class Figure {
    double dim1;
    double dim2;

    public Figure(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }

    abstract double area();
}

class Rectangle extends Figure {
    public Rectangle(double dim1, double dim2) {
        super(dim1, dim2);
    }

    @Override
    double area() {
        System.out.println("В области четырехугольника.");
        return dim1 * dim2;
    }
}

class Triangle extends Figure {
    public Triangle(double dim1, double dim2) {
        super(dim1, dim2);
    }

    @Override
    double area() {
        System.out.println("В области треугольника.");
        return dim1 * dim2 / 2;
    }
}
