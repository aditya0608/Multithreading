package com.aditya.threadStates;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ThreadDownload implements Runnable{
    private String fileName;
    private String URL;
    static String absPath="C:\\Users\\ADITYA SHARMA\\Downloads\\LiveStreamRest\\Multithreading\\src\\com\\aditya\\threadStates\\resources\\";
    public ThreadDownload(String fileName,String URL) {
        this.fileName=fileName;
        this.URL=URL;
    }

    @Override
    public void run() {
        InputStream image= null;
        try {
            image = new URL(URL).openStream();
            Files.copy(image, Paths.get("C:\\Users\\ADITYA SHARMA\\Downloads\\LiveStreamRest\\Multithreading\\src\\com\\aditya\\threadStates\\resources\\"+fileName+".JPEG"));
            Thread threadView=new Thread(new ThreadView(absPath+fileName+".JPEG"));
            threadView.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
