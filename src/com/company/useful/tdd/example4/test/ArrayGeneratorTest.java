package company.useful.tdd.example4.test;


import company.useful.tdd.example4.Generator;
import company.useful.tdd.example4.Generators;

import java.util.Arrays;

public class ArrayGeneratorTest {

    public static void start() {
        int size = (int) (Math.random() * 30);

        Generator<Integer> intGen = new Generators.IntegerGenerator(100);
        Generator<Boolean> boolGen = new Generators.BooleanGenerator();

        int[] integers = new int[size];
        boolean[] booleans = new boolean[size];

        for (int i = 0; i < integers.length; i++) {
            integers[i] = intGen.next();
        }
        for (int i = 0; i < booleans.length; i++) {
            booleans[i] = boolGen.next();
        }

        System.out.println("size = " + size);
        System.out.println("ints: " + Arrays.toString(integers));
        System.out.println("bools: " + Arrays.toString(booleans));

    }
}
