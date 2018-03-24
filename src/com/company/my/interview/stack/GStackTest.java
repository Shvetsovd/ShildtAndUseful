package company.my.interview.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 23.03.2018.
 */
public class GStackTest {
    private static final int TOTAL_ITERATIONS = 200000;
    private GStack<String> stack;

    @Before
    public void init(){
        stack = new GStack<>();
    }

    @Test
    public void pushStressTest() {
        loadStack(TOTAL_ITERATIONS);
    }

    private void loadStack(int n) {
        for (int i = 0; i < n; i++) {
            stack.push("" + i);
        }
    }

    @Test
    public void pushPopTest() {
        loadStack(TOTAL_ITERATIONS);
        int i = TOTAL_ITERATIONS;
        while (i > 0) {
            Assert.assertEquals("" + --i, stack.pop());
        }
    }

    @Test
    public void peekTest() {
        loadStack(TOTAL_ITERATIONS);
        int i = TOTAL_ITERATIONS - 1;
        int j = TOTAL_ITERATIONS;
        while (j-- > 0) {
            Assert.assertEquals("" + i, stack.peek());
        }
    }

    @Test
    public void isEmptyTest() {
        Assert.assertTrue(stack.isEmpty());
        stack.push("Hello");
        Assert.assertFalse(stack.isEmpty());
    }
}