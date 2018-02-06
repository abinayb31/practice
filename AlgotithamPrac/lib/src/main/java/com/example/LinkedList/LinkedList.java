package com.example.LinkedList;

import java.util.HashSet;

/**
 * Created by bandaab on 1/14/18.
 */

public class LinkedList {
    private static class Node{
        private int value;
        private Node next;
        public Node(int v, Node n){
            value = v;
            next = n;
        }
    }
    private Node head;
    private int size = 0;
    public int size(){
        return size;
    }

    public void addHead(int value){
        head = new Node(value,head);
        size++;
    }

    public void addTail(int value){
        Node newNode = new Node(value,null);
        Node curr = head;
        if(head == null){
            head = newNode;
        }

        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void sortedInsertion(int value){
        Node newNode = new Node(value,null);
        Node curr = head;
        if(curr == null || curr.value>value){
            newNode.next = head;
            head = newNode;
            return;
        }
        while(curr.next != null && curr.next.value < value){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
    }

    public boolean isPresent(int value){
        Node curr = head;
        while(curr != null){
            if(curr.value == value){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void removeDuplicatesSorted() {
        Node curr = head;
        while(curr != null){
            if(curr.next != null && curr.value == curr.next.value){
                curr.next = curr.next.next;
            }else {
                curr = curr.next;
            }
        }
    }

    public void removeDuplicatesUnSorted() {
        HashSet<Integer> set = new HashSet<>();
        Node privious = null;
        Node curr = head;
        while (curr != null){
            if(set.contains(curr.value)){
                privious.next= curr.next;
            } else {
                set.add(curr.value);
                privious = curr;
            }
            curr = curr.next;
        }
    }

    public void printKthElementFromLast(int kValue){
        Node curr1 = head;
        Node curr2 = head;

        for(int i =0;i<kValue;i++){
            if(curr1 == null){
                System.out.print(" null ");
            }
            curr1 = curr1.next;

        }

        while(curr1 != null){
            System.out.println("curr1 value "+curr1.value+" curr2 value "+curr2.value);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        System.out.println("kth value"+curr2.value);
    }

    public void removeNode(int value){
        Node curr = head;
        if(curr == null || curr.next == null){
            System.out.print(" null ");
        }

        while(curr != null){
            if(curr.next != null && curr.next.value == value){
                curr.next= curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }
}

