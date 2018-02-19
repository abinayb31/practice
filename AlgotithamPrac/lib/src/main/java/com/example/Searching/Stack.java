package com.example.Searching;

/**
 * Created by bandaab on 2/11/18.
 */

public class Stack {
    private static final int Capacity = 100;
    int[] data;
    private int top = -1;
    public  Stack() {
        this(Capacity);
    }

    public Stack(int capacity){
        data = new int[capacity];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int size(){
        return top+1;
    }

    public void print(){
        for (int i=top;i>-1;i--){
            System.out.println(data[i]);
        }
    }

    public void push(int value){
        if(size() == data.length) throw new IllegalStateException("StackOverFlow");
        top++;
        data[top] = value;
    }

    public void pop(){
        if(isEmpty()) throw new IllegalStateException("StackEmpty");
        int topValue = data[top];
        top--;
        System.out.println("value poped : "+topValue);
    }

}
