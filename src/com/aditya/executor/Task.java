package com.aditya.executor;

public class Task implements  Runnable{

    private int id;
    public Task(int id)
    {
        this.id=id;
    }
    public void run()
    {
        System.out.println("I am "+id+" running ");
    }
}
