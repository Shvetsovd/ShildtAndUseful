package company.shildt.chapter14;

/**
 * Created by OPER on 24.03.2017.
 */
class TwoD {
    int x, y;

    public TwoD(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ThreeD extends TwoD {
    int z;

    public ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

class FourD extends ThreeD {
    int t;

    public FourD(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }
}

class Coords<T extends TwoD> {
    T[] coords;

    public Coords(T[] coords) {
        this.coords = coords;
    }
}

public class BoundedWildcard {
    static void showXY(Coords<?> c) {
        System.out.println("Координаты SupressTest Y:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " +
                    c.coords[i].y);
        }
        System.out.println();
    }

    public static void showXYZ(Coords<? extends ThreeD> c) {
        System.out.println("Координаты SupressTest Y Z:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " +
                    c.coords[i].y + " " +
                    c.coords[i].z);
        }
        System.out.println();
    }

    public static void showAll(Coords<? extends FourD> c) {
        System.out.println("Координаты SupressTest Y Z:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " +
                    c.coords[i].y + " " +
                    c.coords[i].z + " " +
                    c.coords[i].t);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TwoD td[] = {
                new TwoD(0, 0),
                new TwoD(7, 9),
                new TwoD(18, 4),
                new TwoD(-1, -23)
        };

        Coords<TwoD> tdlocs = new Coords<>(td);
        System.out.println("Содержимое объекта tdlocs.");
        showXY(tdlocs);

        //showXYZ(tdlocs);
        //showAll(tdlocs);

        FourD fd[] = {
                new FourD(1, 2, 3, 4),
                new FourD(6, 8, 14, 8),
                new FourD(22, 9, 4, 9),
                new FourD(3, -2, -23, 17)
        };

        Coords<FourD> fdlocs = new Coords<>(fd);

        System.out.println("Содержимое объекта fdlocs.");
        showXY(fdlocs);
        showXYZ(fdlocs);
        showAll(fdlocs);

    }
}


















