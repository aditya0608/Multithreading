package com.aditya.join;

public class Join {

    public static void main(String[] args) {
        try {
            Thread thread = new Thread(() -> {
                while(true) {
                    System.out.println("I wam waiting ");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread thread2=new Thread(()->{
                System.out.println("I am starting now");
            });
            thread.start();
            thread.join(10000);
            thread2.start();
            System.out.println("Normal thread ");
        }
        catch
        (IllegalStateException | InterruptedException e)
        {
            System.out.println("Exception occured ");
        }
    }
}
