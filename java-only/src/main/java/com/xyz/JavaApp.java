package com.xyz;

import java.util.Random;

public class JavaApp {
    public static void main(String[] args) {
        System.out.println("Simple Java App");
        System.out.println("Results of complex computation" + JavaApp.computation(10));
    }

    public static Double computation(int seed) {
        return new Random(seed).nextDouble();
    }
}
