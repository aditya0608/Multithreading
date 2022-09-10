package com.aditya.creation;

public class Extending extends  Thread{

    @Override
    public void run()
    {
        System.out.println("Called by "+ Thread.currentThread().getName().toString() );
    }
    public static void main(String[] args) {
        Extending extend=new Extending();
        extend.setName("Extending ");
        extend.start();
    }
}
