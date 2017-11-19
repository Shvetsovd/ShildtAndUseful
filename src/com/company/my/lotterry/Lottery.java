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

        nums.add(new LotterryNumber(1,39));
        nums.add(new LotterryNumber(2,36));
        nums.add(new LotterryNumber(3,40));
        nums.add(new LotterryNumber(4,35));
        nums.add(new LotterryNumber(5,42));
        nums.add(new LotterryNumber(6,34));
        nums.add(new LotterryNumber(7,43));
        nums.add(new LotterryNumber(8,40));
        nums.add(new LotterryNumber(9,33));
        nums.add(new LotterryNumber(10,53));
        nums.add(new LotterryNumber(11,45));
        nums.add(new LotterryNumber(12,45));
        nums.add(new LotterryNumber(13,40));
        nums.add(new LotterryNumber(14,39));
        nums.add(new LotterryNumber(15,40));
        nums.add(new LotterryNumber(16,30));
        nums.add(new LotterryNumber(17,39));
        nums.add(new LotterryNumber(18,49));
        nums.add(new LotterryNumber(19,41));
        nums.add(new LotterryNumber(20,44));
        Lottery rapidoBase = new Lottery("RapidoBase", 8, nums);
        rapidoBase.generate();

        nums.clear();

        nums.add(new LotterryNumber(1,27));
        nums.add(new LotterryNumber(2,26));
        nums.add(new LotterryNumber(3,27));
        nums.add(new LotterryNumber(4,21));
        Lottery rapidoExtra = new Lottery("RapidoExtra", 1, nums);
        rapidoExtra.generate();

        System.out.println("RapidoBase: " + rapidoBase.getLotterryNumbers());
        System.out.println("RapidoBase: " + rapidoExtra.getLotterryNumbers());



    }
}
