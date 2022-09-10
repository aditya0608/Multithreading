package com.aditya.practice;

import java.io.*;

public class Transient   {

    public static void main(String[] args) {
        Person person=new Person(1,"dddd");
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\ADITYA SHARMA\\Downloads\\LiveStreamRest\\Multithreading\\src\\com\\aditya\\practice\\object.txt")));
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
            objectOutputStream.flush();
            System.out.println("Written success ");
            System.out.println("Reading now");
            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(new File("C:\\Users\\ADITYA SHARMA\\Downloads\\LiveStreamRest\\Multithreading\\src\\com\\aditya\\practice\\object.txt")));
                System.out.println((Person)objectInputStream.readObject());
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable
{
    int id;
    transient String password;

    public Person(int id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}';
    }
}
