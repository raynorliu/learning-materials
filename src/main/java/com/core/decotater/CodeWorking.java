package com.core.decotater;

/**
 * @author raynor
 */
public class CodeWorking implements Work {

    @Override
    public void run() {
        try {
            System.out.println("begin work");
            Thread.sleep(5000);
            System.out.println("work end");
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
