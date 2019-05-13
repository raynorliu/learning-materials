package com.core.decotater;

/**
 * @author raynor
 */
public class Logging implements Work {
    private Work work;

    public Logging(Work work) {
        this.work = work;
    }

    @Override
    public void run() {
        long timeMillis = System.currentTimeMillis();
        System.out.println("begin work time: " + timeMillis);
        work.run();
        System.out.println("end work time: " + (System.currentTimeMillis() - timeMillis));
    }
}
