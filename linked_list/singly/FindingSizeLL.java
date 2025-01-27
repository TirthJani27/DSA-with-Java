package com.dsa.javalearning.linked_list.singly;
public class FindingSizeLL {
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next=null;
        }
    }
    Node head;
    Node tail;
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
    public void removeHead(){
        head=head.next;
    }
    public int LLsize(){
        int i=0;
        Node curr = head;
        for(i=0;;i++){
            if(curr.next==null){
                return i;
            }
        }
    }
    public int findingKey(int key){
        int i=0;
        Node curr=head;
        while(curr.next!=null){
            if(curr.data==key){
                return i;
            }
            curr=curr.next;
            i++;
        }
        return -1;
    }
    public void reverseLL() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public int sizeLL() {
        Node curr=head;
        int i=0;
        while(curr!=null) {
            curr=curr.next;
            i++;
        }
        return i;
    }


    public static void main(String args[]){
        FindingSizeLL list1 = new FindingSizeLL();
        list1.addFirst(1);


        list1.addlast(2);
        System.out.println("");
        list1.addlast(3);

        list1.printll();
        System.out.println("");
        list1.reverseLL();
        list1.printll();

        System.out.println(" ");
        System.out.println(list1.sizeLL());
    }
}