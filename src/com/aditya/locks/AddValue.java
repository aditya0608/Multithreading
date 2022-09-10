package com.aditya.locks;

public class AddValue {

     static int counter=0;
     static void add(int value)
    {
        counter=counter+value;
        System.out.print(counter+"  ");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        for(int i=0;i<20;i++) {
            new Thread(() -> {
                add(1);
                if(Math.random()%2==0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }





    }
}
