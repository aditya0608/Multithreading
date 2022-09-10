package com.aditya.copypaste.readers;

import com.aditya.copypaste.Readers;
import com.aditya.copypaste.Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Sam implements Readers {
    File file;
    String lineFound="";
    BufferedWriter writer;
    public Sam()
    {
        file=new File("C:\\Users\\ADITYA SHARMA\\Downloads\\LiveStreamRest\\Multithreading\\src\\com\\aditya\\copypaste\\readers\\Sam.txt");
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
