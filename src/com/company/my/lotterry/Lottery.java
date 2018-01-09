package company.my.lotterry;

import java.util.*;

class LotterryNumber{
    int number;
    int frequency;

    public LotterryNumber(int number, int frequency) {
        this.number = number;
        this.frequency = frequency;
    }
}
public final class Lottery {
    private Random random;

    private String lotterryName;
    private List<Integer> allNumbers;
    private List<Integer> lotterryNumbers;
    private int countForGenerate;

    private int minNumber;
    private int maxNumber;

    public Lottery(String lotterryName, int countForGenerate, List<LotterryNumber> lotterryNumbers){
        this.lotterryName = lotterryName;
        this.countForGenerate = countForGenerate;
        this.minNumber = Collections.min(lotterryNumbers, Comparator.comparingInt(a -> a.number)).number;
        this.maxNumber = Collections.max(lotterryNumbers, Comparator.comparingInt(a -> a.number)).number;

        allNumbers = new ArrayList<>();
        for(LotterryNumber ln : lotterryNumbers){
            for (int i = 0; i < ln.frequency; i++) {
                allNumbers.add(ln.number);
            }
        }
        Collections.shuffle(allNumbers);
    }

    public Lottery(String lotterryName, int countForGenerate, int minNumber, int maxNumber, int step, int... luckyNumbers) {
        if (countForGenerate <= 0) {
            throw new IllegalArgumentException("Count lotterryNumbers for generate must be positive");
        }
        if (maxNumber < minNumber) {
            throw new IllegalArgumentException("Max number can't be less min number");
        }
        this.lotterryName = lotterryName;
        this.countForGenerate = countForGenerate;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;

        allNumbers = new ArrayList<>();
        for (int number = minNumber; number <= maxNumber; number += step) {
            allNumbers.add(number);
        }
        for (int luckyNumber : luckyNumbers) {
            if (allNumbers.contains(luckyNumber)) {
                allNumbers.add(luckyNumber);
            }
        }
    }


    public Lottery(String lotterryName, int countForGenerate, int maxNumber, int... luckyNumbers) {
        this(lotterryName, countForGenerate, 1, maxNumber, 1, luckyNumbers);
    }

    public List<Integer> getLotterryNumbers() {
        return new ArrayList<>(lotterryNumbers);
    }

    public String getLotterryName() {
        return lotterryName;
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

    public void generate() {
        random = new Random(System.currentTimeMillis());
        lotterryNumbers = new ArrayList<>();

        while (lotterryNumbers.size() < countForGenerate) {
            int newNumber = allNumbers.get(random.nextInt(allNumbers.size()));
            if (lotterryNumbers.contains(newNumber)) {
                continue;
            }
            lotterryNumbers.add(newNumber);
        }
        Collections.sort(lotterryNumbers);
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "\nlotterryName = '" + lotterryName + '\'' +
                ", countForGenerate = " + countForGenerate +
                ", minNumber = " + minNumber +
                ", maxNumber = " + maxNumber +
                "\nlotterryNumbers = " + lotterryNumbers +
                "\n}\n";
    }
}

class LotterryTest {
    public static void main(String[] args) {
        /*Lottery rapidoBase = new Lottery("RapidoBase", 8, 20, new int[]{1, 7, 12, 12});
        Lottery rapidoExtra = new Lottery("RapidoExtra", 1, 4);*/

        ArrayList<LotterryNumber> nums = new ArrayList<>();

        nums.add(new LotterryNumber(1,231));
        nums.add(new LotterryNumber(2,228));
        nums.add(new LotterryNumber(3,238));
        nums.add(new LotterryNumber(4,214));
        nums.add(new LotterryNumber(5,228));
        nums.add(new LotterryNumber(6,212));
        nums.add(new LotterryNumber(7,234));
        nums.add(new LotterryNumber(8,226));
        nums.add(new LotterryNumber(9,223));
        nums.add(new LotterryNumber(10,240));
        nums.add(new LotterryNumber(11,223));
        nums.add(new LotterryNumber(12,255));
        nums.add(new LotterryNumber(13,214));
        nums.add(new LotterryNumber(14,218));
        nums.add(new LotterryNumber(15,220));
        nums.add(new LotterryNumber(16,212));
        nums.add(new LotterryNumber(17,215));
        nums.add(new LotterryNumber(18,224));
        nums.add(new LotterryNumber(19,239));
        nums.add(new LotterryNumber(20,219));
        Lottery rapidoBase = new Lottery("RapidoBase", 8, nums);
        rapidoBase.generate();

        nums.clear();

        nums.add(new LotterryNumber(1,143));
        nums.add(new LotterryNumber(2,147));
        nums.add(new LotterryNumber(3,135));
        nums.add(new LotterryNumber(4,139));
        Lottery rapidoExtra = new Lottery("RapidoExtra", 1, nums);
        rapidoExtra.generate();

        System.out.println("RapidoBase: " + rapidoBase.getLotterryNumbers());
        System.out.println("RapidoBase: " + rapidoExtra.getLotterryNumbers());



    }
}
