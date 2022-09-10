package com.aditya.locking;

/* Custom object is used here to lock on obj1 and obj2 hence increment 1 and increemnt2 can be
 accessed simultaneously

 using final is great as it will not allow reference(say obj3 starts pointing to obj1) to change hence only one run per object
*/
public class CustomObjectLocking {
    static int counter1 = 0;
    static int counter2 = 0;
    static final Object obj1 = new Object();
    static final Object obj2 = new Object();

    public static void increment1() {
        synchronized (obj1) {
            CustomObjectLocking.counter1++;
        }
    }

    public static void increment2() {
        synchronized (obj2) {
            CustomObjectLocking.counter2++;
        }
    }

    public static void process() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    increment1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++)
                    increment2();
            }
        });
    }

    public static void main(String[] args) {
        process();
        System.out.println("Counter 1" + counter1);
        System.out.println("Counter 2" + counter2);

    }
}
