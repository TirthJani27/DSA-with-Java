package com.dsa.javalearning.linkedlist2;

public class DoublyLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

        public static Node head;
        public static Node tail;
        public static int size=0;

        public void addFirst(int data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        public void printdll() {
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data);
                System.out.print("<->");
                temp=temp.next;
            }
            System.out.print("null");
        }

        public static void main(String args[]) {
            DoublyLL dll = new DoublyLL();
            dll.addFirst(1);
            dll.addFirst(2);
            dll.addFirst(3);
            dll.printdll();
            dll.addFirst(4);
        }
}
