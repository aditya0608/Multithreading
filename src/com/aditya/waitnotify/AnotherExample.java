package com.aditya.waitnotify;

public class AnotherExample implements  Runnable{

    public final Object obj=new Object();
    public  boolean solved=false;
    @Override
    public void run() {
        while(true) {
            solve();
            unsolve();
        }

    }
    public  void solve()
    {
        synchronized (obj)
        {
            while(!solved) {
                System.out.println("waiting  ");
                try {
                    obj.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            solved=true;
            obj.notifyAll();
        }
    }
    public  void unsolve()
    {
        synchronized (obj)
        {
            while(solved) {
                System.out.println("waiting as is solved ");
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            solved=false;
            obj.notifyAll();
        }
    }
    public static void main(String[] args) {
        Thread thread=new Thread(new AnotherExample());
        thread.start();
    }


}
