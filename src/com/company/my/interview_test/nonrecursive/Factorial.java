package company.my.interview_test.nonrecursive;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 27.04.2018.
 */
public class Factorial {
    private static List<Integer> values;

    static {
        values = new ArrayList<>();
        values.add(1);
        fill(5);
    }

    public static Integer get(int n) {
        if (n > values.size() - 1) {
            fill(n);
        }
        return values.get(n);
    }

    private static void fill(int n) {
        for (int i = values.size(); i <= n; i++) {
            int last = values.get(i - 1);
            values.add(last * i);
        }
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Factorial.get(6));
    }
}
