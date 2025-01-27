package com.dsa.javalearning.binarySearchTrees;
public class DeletingNode {
    public static void main(String[] args) {
        Node root=new Node(50);
        root.left=new Node(30);
        root.right=new Node(80);
        root.left.left=new Node(20);
        root.left.right=new Node(40);
        root.right.right=new Node(100);
        root.right.left=new Node(70);
        root.right.left.left=new Node(60);
        inOreder(root);
        deletion_Of_Node(root,60);
        inOreder(root);
    }
    public static Node deletion_Of_Node(Node root,int k){
        Node parent =null;
        Node curr = root;
        while(curr.data!=k) {
            parent=curr;
            if (curr.data > k) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if(parent.left.data==k){
            parent.left=null;
        }else{
            parent.right=null;
        }
        return root;
    }
    public static void inOreder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        inOreder(root.left);
        inOreder(root.right);
    }
}
