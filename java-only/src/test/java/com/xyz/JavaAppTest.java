package com.xyz;

import org.junit.Test;

public class JavaAppTest {

    @Test
    public void computationResultsShouldBeSameForSameFeed() {
        double result1 = JavaApp.computation(10);
        double result2 = JavaApp.computation(10);

        org.junit.Assert.assertEquals(result1, result2, 0.1);
    }
}
