package com.example.bandaab.singletonpractice;

import java.io.Serializable;

/**
 * Created by bandaab on 1/12/18.
 */

public class SingletonClass implements Serializable {
    private static volatile SingletonClass singletonClassInstance;

    private SingletonClass(){
        //Prevent form the reflection api.
        if (singletonClassInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }


    public static SingletonClass getInstance(){
        if(singletonClassInstance == null){
            synchronized (SingletonClass.class){
                if(singletonClassInstance == null) singletonClassInstance = new SingletonClass();
            }
        }
        return singletonClassInstance;
    }

    protected SingletonClass readResolve() {
        return getInstance();
    }
}
