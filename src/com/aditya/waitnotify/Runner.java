package com.aditya.waitnotify;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Runner {
    public  static int MAX_CAPACITY=4;
    public static void main(String[] args) {
          final List<Integer> taskQueue=new LinkedList<>();

        Thread producer=new Thread(new Producer(taskQueue,5));
        Thread consumer=new Thread(new Consumer(taskQueue));

        consumer.start();
        producer.start();





    }
}
