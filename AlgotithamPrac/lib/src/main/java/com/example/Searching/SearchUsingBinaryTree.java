package com.example.Searching;

/**
 * Created by bandaab on 2/10/18.
 */

public class SearchUsingBinaryTree {
    public static void main(String[] args) {

        BinaryTree theTree = new BinaryTree();

        theTree.addNode(12);
        theTree.addNode(3);
        theTree.addNode(4);
        theTree.addNode(7);
        theTree.addNode(8);
        theTree.addNode(11);
        theTree.addNode(10);
        theTree.addNode(5);
        theTree.addNode(6);
        theTree.addNode(9);
        theTree.addNode(2);
        theTree.addNode(1);









        // Different ways to traverse binary trees

//        theTree.inOrderTraverseTree(theTree.root);

//         theTree.preorderTraverseTree(theTree.root);

//         theTree.postOrderTraverseTree(theTree.root);

        // Find the node with key 75

//        System.out.println("\nNode with the key 75");
//
//        System.out.println(theTree.findNode(75));
        System.out.println("Depth ==>"+theTree.maxDepth(theTree.root));

    }
}
