package company.shildt.chapter7;

/**
 * Created by dmitry on 31.01.17.
 */
class Box {
    double width;
    double height;
    double depth;

    Box (Box ob){
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }


    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    public Box(double len) {
        width = height = depth = len;
    }

    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    double volume() {
        return width * height * depth;
    }


}

class OverloadCons{
    public static void main(String[] args) {
        Box mybox1 = new Box(10, 20, 15);
        Box mybox2 = new Box();
        Box mycube = new Box(7);

        double vol;

        vol = mybox1.volume();
        System.out.println("Объем mybox1 равен " + vol);

        vol = mybox2.volume();
        System.out.println("Объем mybox2 равен " + vol);

        vol = mycube.volume();
        System.out.println("Объем mycube равен " + vol);
    }
}
