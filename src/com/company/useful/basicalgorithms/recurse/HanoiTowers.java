package company.useful.basicalgorithms.recurse;

/**
 * Created by user on 25.04.2017.
 */
public class HanoiTowers {
    public static void hanoi(int q, int from, int to, int buf) {
        if (q != 0) {
            hanoi(q - 1, from, buf, to);
            System.out.println("move 1 plate: " + from + " -> " + to);
            hanoi(q - 1, buf, to, from);
        }
    }

    public static void main(String[] args) {
        hanoi(5, 1, 2, 3);
    }
}
