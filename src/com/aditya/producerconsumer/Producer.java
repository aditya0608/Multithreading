package com.aditya.producerconsumer;
import java.util.concurrent.BlockingQueue;
import static java.lang.Thread.sleep;

public class Producer implements Runnable{
    BlockingQueue<String > blockingQueue=null;

    public  Producer(BlockingQueue<String > blockingQueue)
    {
        this.blockingQueue=blockingQueue;
    }
    @Override
    public void run() {
        while(true)
        {
            try {
                this.blockingQueue.put(""+ System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName()+" "+"Producer ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
}
