package com.dsa.javalearning.linked_list.singly;
public class Remove_nth_Node_from_last {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
        Node head;
        public void addfirst(int data){
            Node newNode=new Node(data);
            newNode.next=head;
            if(head==null){
                head=newNode;
                return ;
            }
            head=newNode;
        }
        public void addlast(int data){
            Node newNode=new Node(data);
            Node curr = head;
            while(curr.next!=null){
                curr=curr.next;
            }
            curr.next=newNode;

        }
        public void printll() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + "-->");
                curr = curr.next;
            }
            System.out.print("NULL");
        }
        public int sizeLL(){
            Node curr=head;
            int i=0;
            while(curr!=null){
                i++;
                curr=curr.next;
            }
            return i;
        }
        public void removenthnode(int n){
            int size=0;
            Node curr1=head;
            while(curr1!=null){
                size++;
                curr1=curr1.next;
            }
            int i=size-n+1;
            Node curr=head;
            for(int j=1;j<i-1;j++){
                curr=curr.next;
            }
            curr.next=curr.next.next;
        }
    public static void main(String args[]){
        Remove_nth_Node_from_last list=new Remove_nth_Node_from_last();
        list.addfirst(1);
        list.addlast(2);
        list.addlast(3);
        list.addlast(4);
        list.addlast(5);
        list.printll();
        list.removenthnode(1);
        System.out.println("");
        list.printll();
    }
}
