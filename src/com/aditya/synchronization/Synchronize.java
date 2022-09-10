package com.aditya.synchronization;
// Each Object has only one lock which is for its instance methods and variables
//Two threads cannot access the instance variables at the same time hence synchronized is used
//synchronised blocks are more effective as they block only a certain part of code
public class Synchronize {
    static int counter=0;
    public void incrementNonStatic()
    {
        synchronized (this) {
            counter++;
        }
    }
    public static synchronized void increment()
    {
            counter++;
    }
    public static void process() throws InterruptedException {
        Thread thread1=new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<100;i++) {
                    increment();
                }
            }
        });
        Thread thread2=new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<100;i++)
                    increment();
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
    public static void main(String[] args) throws InterruptedException {
        process();
        System.out.println("Value of counter is "+ counter);
    }
}
