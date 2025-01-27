package com.dsa.javalearning.binarySearchTrees;
public class Insertion_in_BST {
    public static Node insertion(Node root,int k){
        Node newNode=new Node(k);
        if(root == null) return newNode;
        Node curr =  root;
        Node parent=null;
        while(curr!=null) {
            parent=curr;
            if(k > curr.data){
                curr=curr.right;
            }else {
                curr=curr.left;
            }
        }
        if(parent.data>k){
            parent.left=newNode;
        }else{
            parent.right=newNode;
        }
        return root;
    }
    public static void main(String[] args) {
        Node root=new Node(50);
        root.left=new Node(30);
        root.right=new Node(80);
        root.left.left=new Node(20);
        root.left.right=new Node(40);
        root.right.right=new Node(100);
        root.right.left=new Node(70);
        root.right.left.left=new Node(60);
        insertion(root,90);
        inOrder(root);
    }
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);

    }
}