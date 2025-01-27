package com.dsa.javalearning.linked_list.singly;

public class LL_practice {
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
    public static void printll1(ListNode head){
        ListNode curr=head;
        while(curr!=null){
            System.out.print(curr.val +"-->");
            curr=curr.next;
        }
        System.out.print("NULL");
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while (fast != null){
            len++;
            fast=fast.next;
        }
        if(n==len){
            return head.next;
        }
        fast=head;
        int i=0;
        while(i != n){
            fast=fast.next;
            i++;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String args[]){
        LL_practice list1 = new LL_practice();
        ListNode newNode = new ListNode(2);
        list1.head = new ListNode(1);
        list1.head.next=newNode;
        printll1(list1.head);
        System.out.println();
        ListNode ans = list1.removeNthFromEnd(list1.head,2);
        printll1(ans);
    }
}