package com.aditya.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements  Runnable{

    BlockingQueue<String> blockingQueue;

    public Consumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            String task= null;
            try {
                task = blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" "+"Consumer : "+task);
        }
    }
}
