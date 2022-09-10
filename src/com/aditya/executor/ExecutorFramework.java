package com.aditya.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*
https://howtodoinjava.com/java/multi-threading/executorservice-shutdown/#:~:text=awaitTermination%20%28long%20timeout%2C%20TimeUnit%20unit%29%20blocks%20until%20all,the%20executor%20service%20takes%20no%20more%20incoming%20tasks.
 Use JProfile for visualization and profiling
 */
public class ExecutorFramework {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors=Executors.newFixedThreadPool(100);

        for(int i=1;i<=1000;i++)
        {
            executors.execute(new Task(i));
        }
        executors.shutdown();
        executors.awaitTermination(60, TimeUnit.SECONDS);
        System.out.println("hello world ");

    }
}
