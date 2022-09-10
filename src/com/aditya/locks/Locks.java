package com.aditya.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {
    static Lock lock=new ReentrantLock();
    static int i=0;
    static boolean isLocked=false;

    public static  void increment()
    {
        while(!isLocked)
        {
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
            isLocked=false;
    }
    public static void breakLock()
    {
        isLocked=true;
    }

    public static void main(String[] args) {
        new Thread(()->{
            Locks.increment();
        }).start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("calling unlock ");
        new Thread(()->{
            Locks.breakLock();
        }).start();
    }
}
