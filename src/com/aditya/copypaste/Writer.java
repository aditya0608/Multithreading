package com.aditya.copypaste;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Writer implements Publisher,Runnable{
    private String fileLocation;
    private List<Readers> readersList;
    File file=new File("C:\\Users\\ADITYA SHARMA\\Downloads\\LiveStreamRest\\Multithreading\\src\\com\\aditya\\resources\\sample-2mb-text-file.txt");
    public Writer(String fileLocation)
    {
        this.fileLocation=fileLocation;
        readersList=new ArrayList<>();
    }


    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public void notifyReaders(String line) {
        for(Readers readers:readersList) {
            readers.write(line);
        }
        }

    @Override
    public void addReader(Readers reader) {
        readersList.add(reader);

    }

    @Override
    public void deleteReader(Readers reader) {
        int readerIndex=readersList.indexOf(reader);
        if(readerIndex!=-1)
            readersList.remove(reader);


    }

    @Override
    public void run() {
        String line ;
        try {
            BufferedReader reader=new BufferedReader(new FileReader(file));
            while((line=reader.readLine())!=null) {
                //System.out.println(line);
                notifyReaders(line);
            }
            if(line==null)
                notifyReaders("EXIT");
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
