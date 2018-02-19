package com.example.Searching;

/**
 * Created by bandaab on 2/11/18.
 */

public class DoubleLinkedList {

    private Node head;
    private Node tail;
    private int size = 0;

    public static class Node{
        private int value;
        private Node next;
        private Node prev;
        public  Node(int v, Node nxt, Node pre){
            this.value = v;
            next = nxt;
            prev = pre;
        }

        public  Node(int v){
            value = v;
            next = null;
            prev = null;
        }
    }





    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void addElement(int value){
        Node newNode = new Node(value,null,null);
        if(size == 0){
            tail = head = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void print(){
        Node temp = head;
        while(temp != null){
            System.out.println("value is :"+ temp.value);
            temp = temp.next;
        }
    }

    public void removeNode(int value){
        Node curr = head;
        if(curr == null){
            System.out.println("List is empty");
        }

        if(curr.value == value){
            head = head.next;
            size--;
            if(head == null){
                head.prev = null;
            }else{
                tail = null;
            }
            return;
        }

        while(curr.next != null){
            if(curr.next.value == value){
                curr.next = curr.next.next;
//                if(curr.next == null){
//                    tail = curr;
//                } else {
//                    curr.next = curr;
//                }
                size--;
            }
            curr = curr.next;
        }
    }
}
