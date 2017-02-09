package company.shildt.chapter8;

/**
 * Created by OPER on 06.02.2017.
 */
public class RefDemo {
    public static void main(String[] args) {
        BoxWeight weightBox = new BoxWeight(3, 5, 7, 8.37);
        Box plainBox = new Box();
        double vol;

        vol = weightBox.volume();
        System.out.println("Объем weightbox равен " + vol);
        System.out.println("Вем weightBox равен " + weightBox.weight);
        System.out.println();

        plainBox = weightBox;
        vol = plainBox.volume();

        System.out.println("Объем plainBox равен " + vol);
        //System.out.println("Вес plainbox равен " + plainBox.weight);
    }
}
