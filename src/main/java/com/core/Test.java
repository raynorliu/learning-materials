package com.core;

/**
 * @author raynor
 */
public class Test {

    public static void main(String[] args) {
        int age=0;
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 11; j++) {
                age++;
            }
        }
        System.out.println(age);
    }
}
