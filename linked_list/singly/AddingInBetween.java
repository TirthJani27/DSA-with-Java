package com.dsa.javalearning.linked_list.singly;
public class AddingInBetween {
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
            while(curr.next!=null){
                System.out.print(curr.data+"-->");
                curr=curr.next;
            }
            System.out.print("NULL");
        }
        public void addBetween(int data,int idx){
            Node newNode=new Node(data);
            if(idx==0){
                addFirst(data);
                return;
            }
            int i=0;
            Node curr=head;
            for( i=0;i<idx-1;i++){
                curr=curr.next;
            }
            newNode.next=curr.next;
            curr.next=newNode;
        }
    static int intersectPoint(Node head1, Node head2)
    {
        // code here
        Node curr1=head1;
        Node curr2=head2;
        while(curr1!=curr2){
            if(curr1==null) curr1=head2;
            else curr1=curr1.next;

            if(curr2.next==null) curr2=head1;
            else curr2=curr2.next;
        }
        return curr2.data;
    }

        public static void main(String args[]){
            AddingInBetween list1 = new AddingInBetween();
            AddingInBetween list2 = new AddingInBetween();
            list1.head=new Node(3);
            list1.head.next=new Node(6);
            list1.head.next.next=new Node(9);
            list1.head.next.next.next=new Node(15);
            list1.head.next.next.next.next=new Node(30);

            list2.head=new Node(10);
            list2.head.next=list1.head.next.next.next;
            list2.head.next.next=list1.head.next.next.next.next;
            System.out.println(intersectPoint(list1.head,list2.head));

        }
    }
