package com.aditya.copypaste;

public interface Publisher {

    void notifyReaders(String line);
    void addReader(Readers reader);
    void deleteReader(Readers reader);
}
