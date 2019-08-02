package org.gmnz.ipk;

import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() {
        HelloWorld hw = new HelloWorld();
        String expected = "Hello world";
        Assert.assertEquals(expected, hw.sayHello());
    }

}