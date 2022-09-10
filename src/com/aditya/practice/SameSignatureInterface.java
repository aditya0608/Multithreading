package com.aditya.practice;

public class SameSignatureInterface implements One,Two{
    @Override
    public void m1(int n) {
        System.out.println(n);
    }

    public static void main(String[] args) {
        SameSignatureInterface sameSignatureInterface=new SameSignatureInterface();
        sameSignatureInterface.m1(5);
    }
}
