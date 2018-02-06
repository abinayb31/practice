package com.example.Stack;

/**
 * Created by bandaab on 1/14/18.
 */

public class Stack {
    private static class StackNode<Integer>{
        private int data;
        private StackNode<Integer> next;

        public StackNode(int data){
            this.data = data;
        }
    }
}
