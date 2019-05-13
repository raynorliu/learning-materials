package com.core.decotater;

/**
 * 装饰者模式
 * @author raynor
 */
public class DecoratorTest {
    public static void main(String[] args) {
        new Logging(new Transitioning(new CodeWorking())).run();
    }
}
