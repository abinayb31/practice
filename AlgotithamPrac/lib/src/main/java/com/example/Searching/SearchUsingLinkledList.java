package com.example.Searching;

/**
 * Created by bandaab on 2/10/18.
 */

public class SearchUsingLinkledList {
    public static void main(String[] args){
//        LinkedList ll = new LinkedList();
//        ll.sortedInsertion(2);
//        ll.sortedInsertion(1);
//        ll.sortedInsertion(3);
//        ll.sortedInsertion(4);
//        ll.sortedInsertion(4);
//        ll.sortedInsertion(8);
//        ll.print();
//        System.out.println(ll.searchNode(5));
//        System.out.println(ll.isDuplicates());
//        System.out.println(ll.findNthElementFromHead(7));
//        System.out.println(ll.findNthElementFromTail(0));
//        ll.removeDuplicates();
//        ll.print();
//        ll.reverseList();
//        ll.print();
//        ll.copyList().print();

//        LinkedList ll2 = new LinkedList();
//        ll2.sortedInsertion(1);
//        ll2.sortedInsertion(3);
//        ll2.sortedInsertion(4);
//        ll2.sortedInsertion(4);
//        ll2.sortedInsertion(8);
//
//        System.out.println(ll.compareList(ll, ll2));

        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addElement(2);
        dll.addElement(4);
        dll.addElement(5);
        dll.addElement(6);
        dll.print();

        dll.removeNode(5);
        dll.print();


    }
}