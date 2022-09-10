package com.aditya.SocketProject.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client3 {

    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;
    public Client3() {
        try {
            socket=new Socket("127.0.0.1",7777);
            System.out.println("Sending request to server");

            System.out.println("Connection done ....");
            bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter=new PrintWriter(socket.getOutputStream());


            startReading();
            startWriting();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void startWriting() {
        //will write to output stream

        Runnable writable=()-> {
            System.out.println("Writer starting ");

            while (true) {

                try {
                    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                    String message = null;
                    message = console.readLine();
                    printWriter.println(message);
                    printWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(writable).start();

    }

    private void startReading() {
        //will read from socket

        Runnable reader=()->{

            System.out.println("Reader  starting ");

            while(true)
            {
                try {
                    String message=bufferedReader.readLine();
                    if(message.equalsIgnoreCase("exit"))
                    {
                        System.out.println("Client terminated the chat ");
                        break;
                    }
                    System.out.println("Server :"+ message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(reader).start();
    }

    public static void main(String[] args) {
        System.out.println("This is client");
        new Client3();
    }
}
