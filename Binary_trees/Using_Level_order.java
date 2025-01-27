package com.dsa.javalearning.Binary_trees;
import java.util.*;
public class Using_Level_order {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
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

        static int i = -1;

        public static Node build(int[] arr) {
            i++;
            if (arr[i] == -1) {
                return null;
            }
            Node newNode = new Node(arr[i]);
            newNode.left = build(arr);
            newNode.right = build(arr);
            return newNode;
        }

        public static int countNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int r = countNodes(root.right);
            int l = countNodes(root.left);
            int total = r + l + 1;
            return total;
        }

        public static int diameter(Node root) {
            if (root == null) {
                return 0;
            }
            int rh = height(root.left);
            int lh = height(root.right);
            int dia = rh + lh + 1;
            int rt = diameter(root.left);
            int lt = diameter(root.left);
            int max = Math.max(dia, rt);
            int ans;
            if (max == rt) {
                ans = Math.max(rt, lt);
            } else {
                ans = Math.max(dia, lt);
            }
            return ans;
        }


        public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.left.left = new Node(4);
            root.right = new Node(3);
            root.left.right = new Node(5);
            root.left.right.right = new Node(6);
            root.left.right.right.right = new Node(7);
            printLevelOrder(root);


        }

        //Level order travesal//
        public static void printLevelOrder(Node root) {
            int h = height(root);
            for (int i = 1; i <= h; i++) {
                curentLevel(root, i);
            }
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            if (lh > rh) {
                return lh + 1;
            } else {
                return rh + 1;
            }
        }

        public static void curentLevel(Node root, int h) {
            if (root == null) {
                return;
            }
            if (h == 1)
                System.out.print(root.data + " ");
            else if (h > 1) {
                curentLevel(root.left, h - 1);
                curentLevel(root.right, h - 1);
            }
        }
    }
}
