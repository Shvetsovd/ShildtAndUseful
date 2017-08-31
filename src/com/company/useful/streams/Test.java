package company.useful.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by OPER on 01.07.2017.
 */
public class Test {
    public static void main(String[] args) {
        int arr[] = {10, 50, 13, -40, 75, 100, 0};
        int sum = 0;

        IntStream stream = Arrays.stream(arr);

        sum = stream.filter((v) -> v > 0 & v % 2 == 0)
                .sorted()
                .reduce(0, (v1, v2) -> v1 + v2);

        System.out.println(sum);


    }
}
