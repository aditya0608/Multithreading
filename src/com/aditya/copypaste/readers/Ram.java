package com.aditya.copypaste.readers;

import com.aditya.copypaste.Readers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ram implements Readers {
    File file;
    String lineFound;
    BufferedWriter writer;
    public Ram()
    {
        file=new File("C:\\Users\\ADITYA SHARMA\\Downloads\\LiveStreamRest\\Multithreading\\src\\com\\aditya\\copypaste\\readers\\Ram.txt");
        try {
            writer=new BufferedWriter(new FileWriter(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void write(String line) {
        try {
            writer.append(line);
            if(line.equalsIgnoreCase("EXIT"))
                writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
