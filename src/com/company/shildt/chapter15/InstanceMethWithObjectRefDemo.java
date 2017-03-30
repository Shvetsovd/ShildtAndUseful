package company.shildt.chapter15;

import java.util.Arrays;

/**
 * Created by OPER on 30.03.2017.
 */
interface MyBiPredicate<T> {
    boolean test(T v1, T v2);
}

class HighTemp {
    private int hTemp;

    public HighTemp(int hTemp) {
        this.hTemp = hTemp;
    }

    boolean sameTemp(HighTemp ht2) {
        return hTemp == ht2.hTemp;
    }

    boolean lessThanTemp(HighTemp ht2) {
        return hTemp < ht2.hTemp;
    }

    @Override
    public String toString() {
        return "" + hTemp;
    }
}

public class InstanceMethWithObjectRefDemo {
    static <T> int counter(T[] vals, MyBiPredicate<T> f, T v) {
        int count = 0;

        for (int i = 0; i < vals.length; i++) {
            if (f.test(vals[i], v)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count;

        HighTemp[] weekDayHighs = {
                new HighTemp(89), new HighTemp(82),
                new HighTemp(90), new HighTemp(89),
                new HighTemp(89), new HighTemp(91),
                new HighTemp(84), new HighTemp(83)
        };
        System.out.println(Arrays.toString(weekDayHighs));

        count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));

        System.out.println("Дней, когда максимальная температура была 89: " + count);

        HighTemp[] weekDayHighs2 = {
                new HighTemp(32), new HighTemp(12),
                new HighTemp(24), new HighTemp(19),
                new HighTemp(18), new HighTemp(12),
                new HighTemp(-1), new HighTemp(13)
        };
        System.out.println(Arrays.toString(weekDayHighs));

        count = counter(weekDayHighs2, HighTemp::sameTemp, new HighTemp(12));

        System.out.println("Дней, когда максимальная температура была 12: " + count);

        count = counter(weekDayHighs2, HighTemp::lessThanTemp, new HighTemp(89));
        System.out.println("Дней, когда максимальная температура была меньше 89: " + count);

        count = counter(weekDayHighs2, HighTemp::lessThanTemp, new HighTemp(19));
        System.out.println("Дней, когда максимальная температура была меньше 19: " + count);
    }
}
