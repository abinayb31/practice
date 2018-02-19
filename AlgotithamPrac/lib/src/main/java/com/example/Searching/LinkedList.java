package com.example.Searching;

import java.util.HashSet;

/**
 * Created by bandaab on 2/11/18.
 */

public class LinkedList {
    public static class Node{
        private int value;
        private Node next;
        public  Node(int v, Node n){
            value = v;
            next = n;
        }
    }

    private Node head;
    private int size = 0;

    public boolean isEmpty(){
        return size == 0;
    }

    public void addHead(int value){
        head = new Node(value,head);
        size++;
    }

    public void addElement(int value){
        Node newNode = new Node(value,null);
        Node curr = head;
        if(head == null){
            head = newNode;
        }

        while(curr!= null && curr.next != null){
            curr = curr.next;
        }
        if(curr!= null){
            curr.next = newNode;
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

    public void sortedInsertion(int value){
        Node newNode = new Node(value,null);
        Node curr = head;
        size++;
        if(head == null || curr.value>newNode.value){
            newNode.next = head;
            head = newNode;
            return;
        }

        while(curr.next != null && curr.next.value < newNode.value){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    public boolean searchNode(int value){
        Node curr = head;
        while(curr != null && curr.next != null){
            if(curr.value == value){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }



    public void removeNode(int value){
        Node curr = head;
        Node nextNode;
        if (isEmpty()){
            System.out.println("no elements");
        }
        while(curr!=null && head.value == value){
            head = curr.next;
            curr = head;
            size--;
        }
        while(curr != null ){
            nextNode = curr.next;
            if(curr.next != null && curr.next.value == value){
                curr.next = nextNode.next;
                size--;
            } else{
                curr = nextNode;
            }
        }
    }

    public boolean isDuplicates(){
        HashSet<Integer> list = new HashSet<>();
        Node curr = head;
        while (curr != null && curr.next != null){
            if(list.contains(curr.value)){
                return true;
            }
            list.add(curr.value);
            curr = curr.next;
        }
        return false;
    }

    public void removeDuplicates(){
        HashSet<Integer> list = new HashSet<>();
        Node curr = head;
        Node prev = null;
        while (curr != null){
            if(curr.next != null && list.contains(curr.value)){
                prev.next = curr.next;
                size --;
            }else{
                list.add(curr.value);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public int findNthElementFromHead(int n){
        int position = 0;
        Node curr = head;
        while(curr != null){
            if(position == n){
                return curr.value;
            }
            position++;
            curr = curr.next;
        }

        return -1;
    }

    public int findNthElementFromTail(int n){
        int position = 1;
        Node curr = head;
        System.out.println(size);
        while(curr != null){
            if(position == size-n){
                return curr.value;
            }
            position++;
            curr = curr.next;
        }

        return -1;
    }

    public void reverseList(){

        Node curr = head;
        Node prev = null;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

    }

    public LinkedList copyList(){
        Node headNode = null;
        Node tailNode = null;
        Node tempNode = null;
        Node curr = head;

        if(curr == null)
            return null;

        headNode = new Node(curr.value, null);
        tailNode = headNode;
        curr = curr.next;

        while(curr != null){
            tempNode = new Node(curr.value,null);
            tailNode.next = tempNode;
            tailNode = tempNode;
            curr = curr.next;
        }

        LinkedList ll2 = new LinkedList();
        ll2.head = headNode;
        return ll2;
    }

    public boolean compareList(LinkedList l1, LinkedList l2){
        return compareList(l1.head, l2.head);
    }

    public boolean compareList(Node n1, Node n2){
        if(n1 == null && n2 == null){
            return true;
        } else if((n1 == null) ||(n2 == null) ||(n1.value != n2.value)){
            return false;
        } else {
            return compareList(n1.next, n2.next);
        }
    }




}
