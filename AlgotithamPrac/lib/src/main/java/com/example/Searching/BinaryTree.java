package com.example.Searching;

/**
 * Created by bandaab on 2/12/18.
 */

/*
public class BinaryTree {
    private static class Node{
        private int value;
        private Node lChild;
        private Node rChild;

        public Node(int v, Node l, Node r){
            value = v;
            lChild = l;
            rChild = r;
        }

        public Node(int v){
            value = v;
            lChild = null;
            rChild = null;
        }
    }

    private Node root;

    public BinaryTree(){
        root = null;
    }

//    public void levelOrderBinaryTree(int[] arr){
//        root = levelOrderBinaryTree(arr, 0);
//    }
//
//    public Node levelOrderBinaryTree(int[] arr , int start){
//        int size = arr.length;
//        Node curr = new Node(arr[start]);
//        int left = 2*start + 1;
//        int right = 2*start + 2;
//
////        System.out.println("List is before-->"+ curr.value+" left "+left+" Right "+right);
//        if(left<size){
//            curr.lChild = levelOrderBinaryTree(arr, left);
////            System.out.println("List is left-->"+ left);
//        }
//
//        if(right<size){
//            curr.rChild = levelOrderBinaryTree(arr, right);
////            System.out.println("List is right-->"+ right);
//        }
//        System.out.println("List is curr after-->"+ curr.value);
//        return curr;
//    }
//


    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node==null) {
            node = new Node(data);
        }
        else {
            if (data < node.value) {
                node.lChild = insert(node.lChild, data);
            }
            else if (data > node.value){
                node.rChild = insert(node.rChild, data);
            }
        }

        return(node); // in any case, return the new pointer to the caller
    }

    public void PrintPreOrder(){
        PrintPreOrder(root);
    }

    private void PrintPreOrder(Node node){
        if(node != null){
            System.out.println("value is "+node.value);
            PrintPreOrder(node.lChild);
            PrintPreOrder(node.rChild);
        }
    }


}
*/

class Node {

    int value;
    String name;

    Node leftChild;
    Node rightChild;

    Node(int value) {

        this.value = value;

    }

    public String toString() {

        return String.valueOf(value);

		/*
		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
		 */

    }

}

public class BinaryTree {

    Node root;

    public void addNode(int value) {

        // Create a new Node and initialize it

        Node newNode = new Node(value);

        // If there is no root this becomes root

        if (root == null) {

            root = newNode;

        } else {

            // Set root as the Node we will start
            // with as we traverse the tree

            Node focusNode = root;

            // Future parent for our new Node

            Node parent;

            while (true) {

                // root is the top parent so we start
                // there

                parent = focusNode;

                // Check if the new node should go on
                // the left side of the parent node

                if (value < focusNode.value) {

                    // Switch focus to the left child

                    focusNode = focusNode.leftChild;

                    // If the left child has no children

                    if (focusNode == null) {

                        // then place the new node on the left of it

                        parent.leftChild = newNode;
                        return; // All Done

                    }

                } else { // If we get here put the node on the right

                    focusNode = focusNode.rightChild;

                    // If the right child has no children

                    if (focusNode == null) {

                        // then place the new node on the right of it

                        parent.rightChild = newNode;
                        return; // All Done

                    }

                }

            }
        }

    }

    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth

    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            // Traverse the left node

            inOrderTraverseTree(focusNode.leftChild);

            // Visit the currently focused on node

            System.out.println(focusNode);

            // Traverse the right node

            inOrderTraverseTree(focusNode.rightChild);

        }

    }

    public void preorderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            System.out.println(focusNode);

            preorderTraverseTree(focusNode.leftChild);
            preorderTraverseTree(focusNode.rightChild);

        }

    }

    public void postOrderTraverseTree(Node focusNode) {

        if (focusNode != null) {

            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);

            System.out.println(focusNode);

        }

    }

    public int maxDepth(Node node){
        if(node == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(node.leftChild);
            int rightDepth = maxDepth(node.rightChild);
            if(leftDepth>rightDepth){
                return leftDepth+1;
            }else{
                return rightDepth+1;
            }
        }
    }

    public Node findNode(int key) {

        // Start at the top of the tree

        Node focusNode = root;

        // While we haven't found the Node
        // keep looking

        while (focusNode.value != key) {

            // If we should search to the left

            if (key < focusNode.value) {

                // Shift the focus Node to the left child

                focusNode = focusNode.leftChild;

            } else {

                // Shift the focus Node to the right child

                focusNode = focusNode.rightChild;

            }

            // The node wasn't found

            if (focusNode == null)
                return null;

        }

        return focusNode;

    }
}


