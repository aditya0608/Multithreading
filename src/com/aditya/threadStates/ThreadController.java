package com.aditya.threadStates;

import java.util.ArrayList;

public class ThreadController {

    public static int NUMBER_OF_DOWNLOAD_THREADS=2;
    public static int NUMBER_OF_VIEW_THREADS=2;
    public static ArrayList<String> urList=new ArrayList<>();
    public static void main(String[] args) {
        urList.add("https://th.bing.com/th/id/OIP.NbjHiO0WjxNwqvjTD7kCJQHaEK?w=309&h=180&c=7&r=0&o=5&dpr=1.25&pid=1.7");
        urList.add("https://th.bing.com/th/id/OIP.seyCiiymkEy2Gz9T3nMKJAHaFj?w=241&h=181&c=7&r=0&o=5&dpr=1.25&pid=1.7");

        //create some thread which download files from server
        for(int i=0;i<NUMBER_OF_DOWNLOAD_THREADS;i++) {
            Thread threadDownload = new Thread(new ThreadDownload("ADAM"+i,urList.get(i)));
            threadDownload.start();
        }




    }
}
