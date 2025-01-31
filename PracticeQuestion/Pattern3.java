
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Pattern3 {
    static class Node{
        int val;
        Node next;
        Node bottom;
        Node (int val){
            this.val = val;
            next = null;
            bottom = null;
        }
    }
    static void printll(Node head){
        Node currR = head;
        while(currR != null){
        }
        System.out.print("NULL");
    }
    public static void main(String[] args) {
        Node newNode = new Node(1);
        newNode.next = new Node(2);
        newNode.next.next = new Node(3);
        newNode.next.next.next = new Node(4);
        newNode.bottom = new Node(5);
        newNode.bottom.next = new Node(6);
        newNode.bottom.next.next = new Node(7);
        newNode.bottom.next.next.next = new Node(8);


        int[] arr = {4,8};
        printll(newNode);

    }
}