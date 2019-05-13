package com.core.decotater;

/**
 * @author raynor
 */
public class Transitioning implements Work {
    private Work work;

    public Transitioning(Work work) {
        this.work = work;
    }

    @Override
    public void run() {
        boolean flag = false;
        try {
            System.out.println("begin transaction");
            work.run();
        } catch (Exception e) {
            flag = true;
            throw e;
        } finally {
            if(flag){
                System.out.println("rollback");
            }else {
                System.out.println("commit");
            }
        }
    }
}
