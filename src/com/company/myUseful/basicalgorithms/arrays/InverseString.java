package company.myUseful.basicalgorithms.arrays;

/**
 * Created by OPER on 19.04.2017.
 */
public class InverseString {
    public static void main(String[] args) {
        String str = "This is a string!";

        System.out.println(str);
        System.out.println(reverse(str));
    }


    private static String reverse(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            int j = chars.length -1 - i;
            swap(chars, i, j);

        }

        return new String(chars);
    }



    private static void swap(char[] a, int i, int j) {
        /*char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;*/

        /*a[i] = (char)(a[i] + a[j]);
        a[j] = (char)(a[i] - a[j]);
        a[i] = (char)(a[i] - a[j]);*/

        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }


}
