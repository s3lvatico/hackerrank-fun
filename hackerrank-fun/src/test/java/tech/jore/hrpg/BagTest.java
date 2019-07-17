package tech.jore.hrpg;


import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BagTest {

    private Bag<Integer> testBag;

    @Before
    public void before() {
        testBag = BagFactory.newIntegerBag();
    }

    @Test
    public void testFactory() {
        Assert.assertNotNull(testBag);
    }

    @Test
    public void testInitialSize() {
        Assert.assertEquals(0, testBag.size());
    }

    @Test
    public void sizeAfterAdd() {
        int updatedSize = testBag.add(64);
        Assert.assertEquals(1, updatedSize);
    }

    @Test
    public void clear() {
        testBag.add(1);
        testBag.add(2);
        testBag.add(3);

        Assert.assertEquals(3, testBag.size());

        testBag.clear();
        Assert.assertEquals(0, testBag.size());
    }

    @Test
    public void iteratorExistenceTest() {
        Iterator<Integer> it = testBag.iterator();
        Assert.assertNotNull(it);
        Assert.assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorWithoutNext() {
        Iterator<Integer> it = testBag.iterator();
        it.next();
    }

    @Test
    public void iteratorWithNextElement() {
        testBag.add(1);
        Assert.assertEquals(1, testBag.size());

        Iterator<Integer> it = testBag.iterator();
        Assert.assertTrue(it.hasNext());

        Integer uno = it.next();
        Assert.assertEquals(new Integer(1), uno);

        Assert.assertFalse(it.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void inductiveIteratorTest() {
        testBag.add(1);
        int bagSize = testBag.add(2);

        Assert.assertEquals(2, bagSize);

        Iterator<Integer> it = testBag.iterator();

        Integer uno = it.next();
        Assert.assertEquals(new Integer(1), uno);

        Assert.assertTrue(it.hasNext());

        Integer due = it.next();
        Assert.assertEquals(new Integer(2), due);
        Assert.assertFalse(it.hasNext());

        it.next();
    }
}