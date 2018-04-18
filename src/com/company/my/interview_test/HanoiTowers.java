package company.my.interview_test;

/**
 * Created by user on 15.04.2018.
 */
public class HanoiTowers {
    public static void hanoi(int count, int from, int to, int buf){
        if (count == 0){
            return;
        }
        hanoi(count - 1, from, buf, to);
        System.out.println("Move: " + from + " -> " + to);
        hanoi(count - 1, buf, to, from);
    }

    public static void main(String[] args) {
        hanoi(5, 1, 2, 3);
    }

}
