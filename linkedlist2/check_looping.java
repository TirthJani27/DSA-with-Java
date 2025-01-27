package com.dsa.javalearning.linkedlist2;
//Floyd's Cycle finding algorithm
public class check_looping {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next=null;
        }
    }
    public Node head;
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return ;
        }
        newNode.next=head;
        head = newNode;
    }
    public void addlast(int data){
        Node newNode=new Node(data);
        Node curr = head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newNode;
    }
    public void printll(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"-->");
            curr=curr.next;
        }
        System.out.print("NULL");
    }
    public void findingMid(Node head){
        Node slow=head;
        Node fast=head;
        while(slow!=null||fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
    }
    public boolean checkLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("Cycle exist");
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
    }

}