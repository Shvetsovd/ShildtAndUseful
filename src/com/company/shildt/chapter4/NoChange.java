package company.shildt.chapter4;

/**
 * Created by user on 17.01.2017.
 */

public class NoChange {
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        for (int x : nums){
            System.out.println(x + " ");
            x *= 10; // не оказывает влияния на массив nums
        }

        System.out.println();

        for (int x : nums) System.out.println(x + " ");

        System.out.println();
    }
}
