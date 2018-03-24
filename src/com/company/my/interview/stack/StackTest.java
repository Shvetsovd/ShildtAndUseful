package company.my.interview.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 23.03.2018.
 */
public class StackTest {
    private Stack stack;
    private static final int TOTAL_ITERATIONS = 200000;

    @Before
    public void init() {
        stack = new Stack();
    }

    @Test
    public void pushStressTest() {
        loadStack(TOTAL_ITERATIONS);
    }

    private void loadStack(int n) {
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
    }

    @Test
    public void pushPopTest() {
        loadStack(TOTAL_ITERATIONS);
        int i = TOTAL_ITERATIONS;
        while (i > 0) {
            Assert.assertEquals(--i, stack.pop());
        }
    }

    @Test
    public void peekTest() {
        loadStack(TOTAL_ITERATIONS);
        int i = TOTAL_ITERATIONS - 1;
        int j = TOTAL_ITERATIONS;
        while (j-- > 0) {
            Assert.assertEquals(i, stack.peek());
        }
    }

    @Test
    public void isEmptyTest() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(1);
        Assert.assertFalse(stack.isEmpty());
    }

}