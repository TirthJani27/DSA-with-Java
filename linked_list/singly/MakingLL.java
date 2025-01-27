package com.dsa.javalearning.linked_list.singly;
public class MakingLL{
        static class ListNode {
            int val;
            ListNode next;

            ListNode(int data){
                this.val = data;
                this.next=null;
            }
        }
        ListNode head;
        public void addFirst(int data){
            ListNode newNode=new ListNode(data);
            if(head==null){
                head=newNode;
                return ;
            }
            newNode.next=head;
            head = newNode;
        }
        public void addlast(int data){
            ListNode newNode=new ListNode(data);
            ListNode curr = head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=newNode;
        }
        public void printll(){
            ListNode curr=head;
            while(curr!=null){
                System.out.print(curr.val +"-->");
                curr=curr.next;
            }
            System.out.print("NULL");
        }
        public void findingMid(ListNode head){
            ListNode slow=head;
            ListNode fast=head;
            while(slow!=null||fast!=null){
                slow=slow.next;
                fast=fast.next;
            }
        }
    public static ListNode rotate(ListNode head, int k) {
        // add code here
        ListNode last;
        ListNode curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        last=curr;
        curr=head;
        for(int i=0;i<k-1;i++){
            curr=curr.next;
        }
        last.next=head;
        head=curr.next;
        curr.next=null;
        return head;
    }
    public static void printll(ListNode head){
            ListNode curr=head;
            while(curr!=null){
                System.out.print(curr.val +"-->");
                curr=curr.next;
            }
        System.out.print("NULL");
    }

        public static void main(String args[]) {
            MakingLL list1 = new MakingLL();
            list1.addFirst(1);
            list1.addlast(2);
            list1.addlast(3);
            list1.printll();
            System.out.println();
            ListNode head=rotate(list1.head,2);
            printll(head);
        }
    }