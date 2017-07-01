package company.myUseful.streams;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * Created by OPER on 01.07.2017.
 */
public class Test2 {
    public static void main(String[] args) {
        int arr[] = {5, 7, 13, 16, 1, -4, 387, 1563, 2699113, 18, -15, 16, 32, 94, 2};

        IntStream stream = Arrays.stream(arr);
        OptionalInt max = stream
                .filter((v) -> v > 0)
                .filter((v) -> v % 2 == 0)
                .sorted()
                .max();

        System.out.println(max.getAsInt());
    }
}
