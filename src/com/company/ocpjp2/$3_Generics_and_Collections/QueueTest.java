package company.ocpjp2.$3_Generics_and_Collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/**
 * Created by user on 24.03.2018.
 */
public class QueueTest {
    public static void main(String[] args) {
        //--- From Collection interface ---
        //boolean add(E element)
        //boolean remove(Object o)
        //boolean contains(Object o)

        //void clear()
        //boolean isEmpty()
        //int size()

        //void forEach(Consumer action)
        //boolean removeIf(Predicate filter)


        //--- From Queue interface ---
        //boolean offer(E e)
        //E element()
        //E remove()
        //E poll()
        //E peek()

        //--- From Deque interface ---
        //void push(E e)
        //E pop()

        //Stack: push/pop/peek push/poll/peek
        //Queue: offer/poll/peek

        //Implementations - LinkedList (Q), ArrayDeque (Q + D)
        dequeTest();
    }

    private static void dequeTest() {
        //Queue: offer-poll-peek
        Queue<Integer> q = new ArrayDeque<>();
        System.out.println(q.offer(10)); //true
        System.out.println(q.offer(5)); //true
        System.out.println(q.offer(7)); //true
        //System.out.println(q.offer(null)); //NullPointerException
        System.out.println(q); //[10, 5, 7]

        System.out.println(q.element()); //10
        System.out.println(q.element()); //10
        System.out.println(q.remove()); //10
        System.out.println(q.remove()); //5
        System.out.println(q);//[7]
        System.out.println(q.peek()); //[7]
        System.out.println(q.peek()); //[7]
        System.out.println(q.poll()); //7
        System.out.println(q.poll()); //null
        //System.out.println(q.element()); //NoSuchElementException
        //System.out.println(q.remove()); //NoSuchElementException

        //Deque: + pop, push
        Deque<Integer> s = new ArrayDeque<>();
        s.push(10); //void
        s.push(5); //void
        s.push(7); //void
        //s.push(null); //NullPointerException

        System.out.println(s); //[7, 5, 10]
        System.out.println(s.peek()); //7
        System.out.println(s.peek()); //7
        System.out.println(s.pop()); //7
        System.out.println(s.poll()); //5
        System.out.println(s.poll()); //10
        System.out.println(s.poll()); //null
        //System.out.println(s.pop()); //NoSuchElementException
    }
}
