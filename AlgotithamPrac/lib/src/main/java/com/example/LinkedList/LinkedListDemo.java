package com.example.LinkedList;

/**
 * Created by bandaab on 1/14/18.
 */

public class LinkedListDemo {
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.addHead(1);
        ll.addTail(2);
        ll.addTail(3);
        ll.addTail(4);
        ll.addTail(5);
        ll.addTail(6);
        ll.addTail(7);
        ll.addTail(8);
        ll.addTail(9);
        ll.addTail(10);
        ll.addTail(11);
//        ll.print();

//        ll.removeDuplicatesUnSorted();
//        ll.print();

        ll.removeNode(3);
        ll.print();

    }
}
