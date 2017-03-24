package company.shildt.chapter14;

/**
 * Created by OPER on 24.03.2017.
 */
public class GenMethDemo {
    static <T extends Comparable<T>, V extends T>
    boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++) {
            if (x == y[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5,};
        if (isIn(2, nums)) {
            System.out.println("Число 2 содержится в массиве nums");
        }
        if (!isIn(7, nums)) {
            System.out.println("Число 7 отсутствует в массиве nums");
        }

        //Можно вызвать так
        //GenMethDemo.<Integer, Integer>isIn(2, nums);

        System.out.println();

        String strs[] = {
                "один",
                "два",
                "три",
                "четыре",
                "пять"
        };

        if (isIn("два", strs)){
            System.out.println("два содержится в массиве strs");
        }
        if (!isIn("семь", strs)){
            System.out.println("семь отсутствует в массиве strs");
        }

        // Error
        /*if (isIn("два", nums)){
            System.out.println("два содержится в массиве nums");
        }*/



    }
}
