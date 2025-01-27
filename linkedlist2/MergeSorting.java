package com.dsa.javalearning.linkedlist2;
public class MergeSorting {
    class Node{
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
    public Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public Node MergeSort(Node head){
        //base
        if(head==null || head.next==null){
            return head;
        }
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next=null;
        Node newLeft=MergeSort(head);
        Node newRight=MergeSort(rightHead);
        return merge(newLeft,newRight);
    }
    private Node merge(Node head1,Node head2){
        Node newLL= new Node(-1);
        Node temp = newLL;
        while(head1!=null&&head2!=null){
            if(head1.data>=head2.data){
                temp.next=head2;
                head2=head2.next;
            }else{
                temp.next=head1;
                head1=head1.next;
            }
            temp=temp.next;
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return newLL.next;
    }

    public static void main(String args[]){
        MergeSorting LL= new MergeSorting();
        LL.addFirst(5);
        LL.addlast(4);
        LL.addlast(9);
        LL.addlast(2);
        LL.addlast(1);
        LL.printll();
        LL.head=LL.MergeSort(LL.head);
        System.out.println("");
        LL.printll();
    }
}
