package com.aditya.practice;

public class StaticMethodOverride {

    static void m1()
    {
        System.out.println("In m1");
    }

    public static void main(String[] args) {
        StaticMethodOverride overriding=new Overriding();
        overriding.m1();
    }
}
class Overriding extends StaticMethodOverride
{
    static void m1()
    {
        System.out.println("In m1 of child");
    }
}