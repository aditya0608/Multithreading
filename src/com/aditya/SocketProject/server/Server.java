package com.aditya.SocketProject.server;

import com.aditya.SocketProject.callback.Notify;
import com.aditya.SocketProject.client.Client1;
import com.aditya.SocketProject.client.SocketObject;

import javax.management.Notification;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    ServerSocket serverSocket;
    Socket socket;

    BufferedReader bufferedReader;
    PrintWriter printWriter;
    List<Notify> subscribers=new ArrayList<>();
    public Server()  {
        try {
            serverSocket=new ServerSocket(7777);
            System.out.println("Sever is ready to accept connection");
            System.out.println("waiting .....");

            while(true) {
                SocketObject socketObject=new SocketObject();
                System.out.println("Waiting for new connection ");
                socket = serverSocket.accept();
                System.out.println("Connection established ... ");
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                printWriter = new PrintWriter(socket.getOutputStream());
                Notify notification=new Client1(socket,bufferedReader,printWriter);
                subscribers.add(notification);
                startReading();
                startWriting();
            }
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

                        for(Notify notify:subscribers) {
                            PrintWriter printWriter=((Client1)notify).getPrintWriter();
                            printWriter.println(message);
                            printWriter.flush();
                        }
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
            while(true) {
                {
                    try {
                        String message = bufferedReader.readLine();
                        if (message.equalsIgnoreCase("exit")) {
                            System.out.println("Client terminated the chat ");
                            break;
                        }
                        System.out.println("Client :" + message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }        };
        new Thread(reader).start();
    }

    public static void main(String[] args)  {
        System.out.println("This is server going to start ...Be Ready  ");
        new Server();
    }
}
