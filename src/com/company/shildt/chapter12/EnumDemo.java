package company.shildt.chapter12;

/**
 * Created by dmitry on 24.02.17.
 */
enum Apple {
    Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap;

        ap = Apple.RedDel;

        System.out.println("Значение ap: " + ap);
        System.out.println();

        ap = Apple.GoldenDel;

        if (ap == Apple.GoldenDel) {
            System.out.println("Переменная ap содержит Goldendel.\n");

            switch (ap){
                case Jonathan:
                    System.out.println("Сорт Jonathan красный");
                    break;
                case GoldenDel:
                    System.out.println("Сорт Golden Delicious желтый");
                    break;
                case RedDel:
                    System.out.println("Сорт Red Delicious красный");
                    break;
                case Winesap:
                    System.out.println("Сорт Winesap красный");
                    break;
                case Cortland:
                    System.out.println("Сорт Cortland красный");
                    break;
            }
        }
    }
}
