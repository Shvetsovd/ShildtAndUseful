package company.shildt.chapter4;

/**
 * Created by user on 16.01.2017.
 */

public class NoBody {
    public static void main(String[] args) {
        int i, j;

        i = 100;
        j = 200;

        while (++i < --j);

        System.out.println("Среднее значение равн " + i);
    }
}
