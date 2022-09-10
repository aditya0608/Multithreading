package com.aditya.join;

public class CatchInterruptedException extends Thread{

    Thread interruptingThread;
    public void run()
    {
        interruptingThread.interrupt();
    }
    public static void main(String[] args) {
        CatchInterruptedException catchInterruptedException=new CatchInterruptedException();
        catchInterruptedException.interruptingThread=Thread.currentThread();
        catchInterruptedException.start();
        try {
            catchInterruptedException.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
