package com.dsa.javalearning.linkedlist2;
//1->2->3->4->5->null --> 1->5->2->4->3->null
public class Zigzac {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addlast(int data) {
        Node newNode = new Node(data);
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void printll() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "-->");
            curr = curr.next;
        }
        System.out.print("NULL");
    }

    public void fun(){
        //mid
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        Node rightHead = mid;
        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        //alt merge
        while (left != null && right != null) {
            nextL = left.next;
            nextR = right.next;
            left.next = right;
            right.next = nextL;
            left = nextL;
            right = nextR;
        }
    }
    public static void main(String args[]){
        Zigzac LL= new Zigzac();
        LL.addFirst(1);
        LL.addlast(2);
        LL.addlast(3);
        LL.addlast(4);
        LL.addlast(5);
        LL.addlast(6);
        LL.printll();
        System.out.println("");
        LL.fun();
        LL.printll();
    }
}

