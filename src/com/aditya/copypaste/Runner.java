package com.aditya.copypaste;

import com.aditya.copypaste.readers.John;
import com.aditya.copypaste.readers.Ram;
import com.aditya.copypaste.readers.Sam;


public class Runner {

    public static void main(String[] args) {
        Writer writer=new Writer("C:\\Users\\ADITYA SHARMA\\Downloads\\LiveStreamRest\\Multithreading\\src\\com\\aditya\\copypaste");
        writer.addReader(new John());
        writer.addReader(new Ram());
        writer.addReader(new Sam());
        Thread writerThread=new Thread(writer);
        writerThread.start();



    }
}
