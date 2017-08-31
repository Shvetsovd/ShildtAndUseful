package company.useful.tdd.example4;

import java.util.Random;

public class Generators {
    public static class IntegerGenerator implements Generator<Integer> {
        private Random r;
        public IntegerGenerator(int bound) {
            r = new Random((int) (Math.random() * bound));
        }

        @Override
        public Integer next() {
            return r.nextInt(100);
        }
    }

    public static class BooleanGenerator implements Generator<Boolean> {
        @Override
        public Boolean next() {
            return Math.random() > 0.5;
        }
    }
}
