package com.dsa.javalearning.Binary_trees;

public class CalculateNodes {
        static class Node{
            int data;
            Node left, right;
            public Node(int data){
                this.data=data;
                this.right=null;
                this.left=null;
            }
        }

        public static int findHeight (Node root) {
            if(root==null){
                return 0;
            }
            int lh=findHeight(root.left);
            int rh=findHeight(root.right);
            int height=0;
            height=height+Math.max(lh,rh);
            return height+1;
        }
        public static int findNodes(Node root){
            if(root==null){
                return 0;
            }
            int ln=findNodes(root.left);
            int rn=findNodes(root.right);
            return ln+rn+1;
        }
        int ans=0;
        public static int nodeData(Node root){
            if(root==null){
                return 0;
            }
            int ans=0;
            int dataleft=nodeData(root.left);
            int dataright=nodeData(root.right);
            ans=dataright + dataleft + root.data;
            return ans;
        }
        public static void main(String[] args) {
        /*
            1
           / \
          2   3
         / \
        4   5
       / \
      n   6
       */
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right=new Node(5);
            root.left.left.right=new Node(6);
            System.out.print(findHeight(root)+"\n");
            System.out.print(findNodes(root)+"\n");
            System.out.print(nodeData(root)+"\n");
        }
}
