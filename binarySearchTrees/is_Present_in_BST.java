package com.dsa.javalearning.binarySearchTrees;
public class is_Present_in_BST {
    static boolean isPreasent1(Node root,int key){
        if(root==null) return false;
        if(root.data==key) return true;
        if(root.data<key) {
            return isPreasent1(root.right, key);
        }
        return isPreasent1(root.left,key);
    }
    static boolean isPresentIterative(int key,Node root){
        Node curr=root;
        while(curr!=null){
            System.out.print(curr.data+" ");
            if(curr.data == key){
                return true;
            } else if (curr.data < key) {
                curr=curr.right;
            }else{
                curr=curr.left;
            }
        }
            return false;
    }
        public static void main(String[] args) {
            Node root=new Node(4);
//            root.left=new Node(20);
//            root.right=new Node(70);
//            root.left.left=new Node(10);
//            root.left.right=new Node(30);
//            root.left.right.right=new Node(40);
//            root.right.right=new Node(80);
//            root.right.left=new Node(60);
            System.out.println(mean(root,9));
        }
    static int mean(Node root, int key){
        // code here
        if(isPreasent1(root,key)){
            return key;
        }
        return getmean(root,key);
    }
    static int getmean(Node root,int key){
        if(root == null){
            return -1;
        }
        if( root.right != null && root.data+root.right.data ==  2*key){
            return key;
        }
        if(root.left != null && root.data+root.left.data ==  2*key){
            return key;
        }
        if( root.left!=null && root.data+root.left.data > 2* key){
            return getmean(root.left,key);
        }
        if(root.right!=null && root.data+root.right.data < 2*key ){
            return getmean(root.right,key);
        }
        return -1;
    }
    static boolean isPresent(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key && root.left.data>key){
            return false;
        }
        if(root.data>key){
            isPresent(root.left,key);
        }
        if(root.data<key && root.right.data<key){
            return false;
        }
        if(root.data<key){
            isPresent(root.right,key);
        }
        return true;
    }
}
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
    }
}
