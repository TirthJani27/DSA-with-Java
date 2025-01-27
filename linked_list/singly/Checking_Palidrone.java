package com.dsa.javalearning.linked_list.singly;
import java.util.*;
public class Checking_Palidrone {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next=null;
        }
    }
    Node head;
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
    public Node findingMid(){
        Node fast=head;
        Node slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public boolean checkPalidrome(){
        //mid
        Node mid=findingMid();
        Node left=head;
        Node right;
        //reversing last half
        Node prev=null;
        Node curr=mid;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        right=prev;

        //checking palidrome
        while(right!=null){
            if(right.data!=left.data){
                return false;
            }
            right=right.next;
            left=left.next;
        }
        return true;
    }
    static Node addTwoLists(Node first, Node second){
        Stack<Long> s = new Stack<>();
        Node temp = first;
        while(temp != null){
            s.add(Integer.toUnsignedLong(temp.data));
            temp=temp.next;
        }
        long firstV = 0;
        long tens = 1;
        while(!s.isEmpty()){
            long val = s.pop() * tens;
            firstV+=val;
            tens*=10;
        }
        temp = second;
        while(temp != null){
            s.add(Integer.toUnsignedLong(temp.data));
            temp=temp.next;
        }
        long secondV = 0;
        tens = 1;
        while(!s.isEmpty()){
            long val = s.pop() * tens;
            secondV+=val;
            tens*=10;
        }
        tens = 10;
        long ans = secondV+firstV;
        while(ans != 0){
            s.add(ans % tens);
            ans/=10;
        }
        Node head = new Node(s.pop().intValue());
        Node pre = head;
        while(!s.isEmpty()){
            Node newNode = new Node(s.pop().intValue());
            pre.next = newNode;
            pre = pre.next;
        }
        return head;
    }
    public static void main(String args[]){
        Checking_Palidrone list1 = new Checking_Palidrone();
        list1.addFirst(4);
        list1.addlast(3);
        list1.addlast(2);
        list1.addlast(5);
        list1.addlast(6);
        list1.addlast(7);
        list1.printll();
        Checking_Palidrone list2 = new Checking_Palidrone();
        list2.addFirst(5);
        list2.addlast(7);
        list2.addlast(9);
        list2.addlast(9);
        list2.addlast(9);
        list2.addlast(8);
        list2.addlast(5);
        list2.addlast(5);
        list2.addlast(3);
        list2.addlast(9);
        list2.addlast(2);
        list2.addlast(9);
        list2.addlast(8);
        list2.addlast(7);
        System.out.println();
        list2.printll();
        Node head3 = addTwoLists(list1.head,list2.head);
        Node curr = head3;
        System.out.println();
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }


    }
}
