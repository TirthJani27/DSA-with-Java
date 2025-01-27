package com.dsa.javalearning.Binary_trees;
public class PreorderTravel {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTrees {
        static int idx = -1;

        public static Node creatBinary(int[] node) {
            idx++;
            if (node[idx] == -1) {
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = creatBinary(node);
            newNode.right = creatBinary(node);
            return newNode;
        }

        public static void preoder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preoder(root.left);
            preoder(root.right);
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            preoder(root.left);
            System.out.print(root.data + " ");
            preoder(root.right);
        }

        public static void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void bhd(Node root) {
            if (root == null) {
                return;
            }
            if (root.left == null) {
                System.out.print(root.data + " ");
                System.out.print(root.right.data + " ");
            }
            if (root.right == null) {
                System.out.print(root.data + " ");
                System.out.print(root.left.data + " ");
            }else{
                System.out.print(root.data+" ");
                System.out.print(root.left.data+" ");
                System.out.print(root.right.data+" ");
            }
            bhd(root.left);
            bhd(root.right);
        }
    }

    public static void main(String[] args) {
        int[] nodes = {5 ,4 ,6 ,3 ,-1 ,-1 ,7 ,-1 ,-1 ,-1 ,8};
        BinaryTrees trees = new BinaryTrees();
        Node n1 = trees.creatBinary(nodes);
        BinaryTrees.preoder(n1);
    }
}






//23/91/214