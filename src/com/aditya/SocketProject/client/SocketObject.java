package com.aditya.SocketProject.client;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketObject {

    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public SocketObject() {
    }

    public SocketObject(Socket socket, BufferedReader bufferedReader, PrintWriter printWriter) {
        this.socket = socket;
        this.bufferedReader = bufferedReader;
        this.printWriter = printWriter;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }
}
