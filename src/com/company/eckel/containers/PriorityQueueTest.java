package company.eckel.containers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.addAll(Arrays.asList(5, 4, 9, 1, 2, 3));

        int length = pq.size();
        for (int i = 0; i < length; i++) {
            System.out.println(pq.poll());
        }

    }
}
