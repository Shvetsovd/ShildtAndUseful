package company.shildt.chapter14;

/**
 * Created by OPER on 24.03.2017.
 */
public class HierDemo3 {
    public static void main(String[] args) {
        Gen<Integer> iob = new Gen<>(88);
        Gen2<String, Integer> iob2 = new Gen2<>("Test", 99);

        Gen2<String, String> strob2 = new Gen2<>("Test2", "Test3");

        if (iob2 instanceof Gen2<?, ?>) {
            System.out.println("Объект iob2 является экземпляром класса Gen2");
        }
        if (iob2 instanceof Gen<?>) {
            System.out.println("Объект iob2 является экземпляром класса Gen");
        }
        if (strob2 instanceof Gen2<?, ?>) {
            System.out.println("Объект strob2 является экземпляром класса Gen2");
        }
        if (strob2 instanceof Gen<?>) {
            System.out.println("Объект strob2 является экземпляром класса Gen");
        }
        System.out.println();

        if (iob instanceof Gen2<?, ?>) {
            System.out.println("Объект iob является экземпляром класса Gen");
        }

        if (iob instanceof Gen<?>) {
            System.out.println("Объект iob является экземпляром класса Gen");
        }

        //Compile Error
        /*if (iob2 instanceof Gen2<Integer, String>){
            System.out.println("Объект iob2 является экземпляром класса Gen2<Integer, String>");
        }*/
    }

}
