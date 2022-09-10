package com.aditya.creation;

/*
Join is used to allow that thread to finish before the subsequent lines process themselves
*/
public class Implementing implements  Runnable{
    @Override
    public void run()
    {
        System.out.println("Calling me by " + Thread.currentThread().getName().toString());
    }
    public static void main(String[] args) throws InterruptedException {
        Object a=new Object();
        Implementing t=new Implementing();
        Thread thread1=new Thread(t);
        thread1.setName("THREAD 1 ");
        Thread thread2=new Thread(new Implementing());
        thread2.setName("THREAD 2");
        // calls override method of Runnable interface
        thread1.start();
        thread1.join();
        //lines will be executed only when thread has stopped processing

        thread2.start();
        thread2.join();
        //lines will be executed only when thread 2 has stopped processing

        //calls override method without creating a new thread
        t.run();
    }
}
