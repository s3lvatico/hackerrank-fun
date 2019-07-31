package tech.jore.hrpg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack<Integer> testStack;

    @Before
    public void before() {
        testStack = StackFactory.newIntegerStack();
    }

    @Test
    public void testFactory() {
        Assert.assertNotNull(testStack);
    }

    @Test
    public void testInitialSize() {
        Assert.assertEquals(0, testStack.size());
    }

    @Test
    public void sizeAfterPush() {
        int sizeAfterPush = testStack.push(64);
        Assert.assertEquals(1, sizeAfterPush);
    }

    @Test
    public void sizeAfterPop() {
        testStack.push(16);
        testStack.push(64);

        testStack.pop();

        Assert.assertEquals(1, testStack.size());
    }

    @Test
    public void popWithNull() {
        Assert.assertNull(testStack.pop());
    }

    @Test
    public void pop() {
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);

        Assert.assertEquals(3, testStack.size());
        
        Integer item = testStack.pop();
        Assert.assertEquals(new Integer(3), item);
        Assert.assertEquals(2, testStack.size());

        item = testStack.pop();
        Assert.assertEquals(new Integer(2), item);
        Assert.assertEquals(1, testStack.size());

        item = testStack.pop();
        Assert.assertEquals(new Integer(1), item);
        Assert.assertEquals(0, testStack.size());

        Assert.assertNull(testStack.pop());
    }

    @Test public void clear() {
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);

        Assert.assertEquals(3, testStack.size());

        testStack.clear();
        Assert.assertNull(testStack.pop());
        Assert.assertEquals(0, testStack.size());
    }

}