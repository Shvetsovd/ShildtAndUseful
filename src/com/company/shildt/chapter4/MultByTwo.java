package company.shildt.chapter4;

/**
 * Created by OPER on 16.01.2017.
 */
public class MultByTwo {
    public static void main(String[] args) {
        int i;
        int num = 0xFFFFFFE;

        for (i = 0; i < 4; i++){
            num <<= 1;
            System.out.println(num);
        }
    }
}
