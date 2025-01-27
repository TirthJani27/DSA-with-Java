package com.dsa.javalearning.linked_list.singly;


public class zXXXample {
    static class Node {
        int val;
        Node next;
        Node random;

        Node(int data) {
            this.val = data;
            this.next = null;
            this.random = null;
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
    }

    public static void printll(Node head) {
        Node curr = head;
        while (curr != null) {
            if (curr.random == null) {
                System.out.print(curr.val + "[ NULL ]" + "-->");

            } else {
                System.out.print(curr.val + "[ " + curr.random + " ]" + "-->");

            }
            curr = curr.next;
        }
        System.out.print("NULL");
    }

    public static Node copyRandomList(Node head) {
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random == null) {
                curr.next.random = null;
            } else {
                Node temp = curr.random;
                curr.next.random = temp.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node newCurr = head.next;
        Node newHead = head.next;
        while (newCurr != null) {
            Node temp1 = curr.next.next;
            curr.next = temp1;
            if (curr.next == null) {
                newCurr.next = null;
            } else {
                newCurr.next = curr.next.next;
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node list1 = new Node(4);
        list1.random = list1.next;
        list1.next = new Node(3);
        list1.next.random = list1.next;
        list1.next.next = new Node(2);
        list1.next.next.random = null;
        list1.next.next.next = new Node(1);
        list1.next.next.next.random = list1;
        list1.next.next.next.next = new Node(0);
        list1.next.next.next.next.random = list1;
        printll(list1);
        System.out.println();
        printll(copyRandomList(list1));
    }
}
