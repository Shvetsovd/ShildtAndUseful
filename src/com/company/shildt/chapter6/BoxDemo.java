package company.shildt.chapter6;

/**
 * Created by OPER on 19.01.2017.
 */
public class BoxDemo {
    public static void main(String[] args) {
        Box mybox = new Box();

        double vol;

        mybox.width = 10;
        mybox.height = 20;
        mybox.depth = 15;

        vol = mybox.width * mybox.height * mybox.depth;
        System.out.println("Объем равен " + vol);
    }
}
