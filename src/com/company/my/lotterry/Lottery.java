package company.my.lotterry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Lottery {
    private Random random = new Random(System.currentTimeMillis());

    private List<Integer> numbers;
    private int countForGenerate;

    private int minNumber;
    private int maxNumber;

    public Lottery(int countForGenerate, int maxNumber) {
        this(countForGenerate, 1, maxNumber);
    }

    public Lottery(int countForGenerate, int minNumber, int maxNumber) {
        if (countForGenerate <= 0) {
            throw new IllegalArgumentException("Count numbers for generate must be positive");
        }
        this.countForGenerate = countForGenerate;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int getCountForGenerate() {
        return countForGenerate;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public List<Integer> getNewNumbers() {
        int sequenceLength = maxNumber - minNumber;
        numbers = new ArrayList<>();

        for (int i = 0; i < countForGenerate; i++) {
            int currentNumber = minNumber + random.nextInt(sequenceLength + 1);
            if (numbers.contains(currentNumber)){
                i--;
                continue;
            }
            numbers.add(currentNumber);
        }
        return new ArrayList<>(numbers);
    }
}

class LotterryTest {
    public static void main(String[] args) {
        Lottery rapidoBase = new Lottery(8, 20);
        Lottery rapidoExtra = new Lottery(1, 4);

        System.out.println(rapidoBase.getNewNumbers());
        System.out.println(rapidoExtra.getNewNumbers());
    }
}
