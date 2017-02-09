package company.shildt.chapter4;

/**
 * Created by user on 17.01.2017.
 */

public class ForEach3 {
    public static void main(String[] args) {
        int sum = 0;
        int nums[][] = new int[3][5];

        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums[i].length; j++){
                nums[i][j] = i + j;
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
        for (int x[] : nums){
            for (int y : x){
                System.out.println("Значение равно: " + y);
                sum += y;
            }
        }
        System.out.println("Сумма: " + sum);
    }
}
