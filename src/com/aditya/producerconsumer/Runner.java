package com.aditya.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Runner {

    //this will take in tasks to be loaded
    static BlockingQueue<String> blockingDeque=new ArrayBlockingQueue<String>(3);
    public static void main(String[] args) {

        Producer producer=new Producer(blockingDeque);

        Consumer consumer=new Consumer(blockingDeque);
        Consumer consumer1=new Consumer(blockingDeque);

        Thread producerThread=new Thread(producer);
        producerThread.start();

        Thread consumerThread=new Thread(consumer);
        Thread consumer1Thread=new Thread(consumer1);
        consumerThread.start();
        consumer1Thread.start();


    }
}
