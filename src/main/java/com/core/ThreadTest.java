package com.core;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author raynor
 */
public class ThreadTest extends Thread {
    private static ReentrantLock lock=new ReentrantLock();
    public void run() {
        while(true){
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }finally{
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        ThreadTest lft=new ThreadTest();
        Thread th1=new Thread(lft);
        Thread th2=new Thread(lft);
        th1.start();
        th2.start();
    }
}
