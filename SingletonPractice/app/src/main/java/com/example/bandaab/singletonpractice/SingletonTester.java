package com.example.bandaab.singletonpractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Created by bandaab on 1/12/18.
 */

public class SingletonTester {
    public static void main(String[] args){
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SingletonClass slIns1 = SingletonClass.getInstance();
//                System.out.println("slIns1"+ slIns1.hashCode());
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SingletonClass slIns2 = SingletonClass.getInstance();
//                System.out.println("slIns2"+ slIns2.hashCode());
//            }
//        });
//
//        t1.start();
//        t2.start();
        try {

            SingletonClass instance1 = SingletonClass.getInstance();
            ObjectOutput out = null;

            out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
            out.writeObject(instance1);
            out.close();

            //deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("singleton.ser"));
            SingletonClass instance2 = (SingletonClass) in.readObject();
            in.close();

            System.out.println("instance1 "+ instance1.hashCode());
            System.out.println("instance2 "+ instance2.hashCode());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
