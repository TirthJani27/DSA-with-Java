package com.dsa.javalearning.Binary_trees;

public class check_subtree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    static class BinaryTree {

        public static class info {
            int h;
            int d;

            info(int h, int d) {
                this.h = h;
                this.d = d;
            }
        }
        public boolean is_identical(Node root,Node subroot){
            if(root==null&&subroot==null){
                return true;
            } else if (root==null||subroot==null||root.data!=subroot.data) {
                return false;
            }
            if(!is_identical(root.left,subroot.left)){
                return false;
            }
            if(!is_identical(root.right,subroot.right)){
                return false;
            }
            return true;
        }
        public boolean check_subtree(Node root,Node subroot){
            if(root==null){
                return false;
            }
            if(root.data==subroot.data){
                if(is_identical(root,subroot)){
                    return true;
                }
            }
            return check_subtree(root.left,subroot)||check_subtree(root.right,subroot);
        }
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);
        root.left.left = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subroot = new Node(2);
        subroot.right= new Node(5);
        subroot.left= new Node(4);
        BinaryTree BT = new BinaryTree();
        System.out.println(BT.check_subtree(root,subroot));

    }
}

