package com.dsa.javalearning.linked_list.singly;

public class CountingSizeLL {
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
            while(curr.next!=null){
                System.out.print(curr.data+"-->");
                curr=curr.next;
            }
            System.out.print("NULL");
        }
        public int LLsize(){
            int i=0;
            Node curr = head;
            while(curr.next!=null){
                curr=curr.next;
                i++;
            }
            System.out.print(i);
            return i;
        }

        public static void main(String args[]){
            CountingSizeLL list1 = new CountingSizeLL();
            list1.addFirst(1);
            list1.addFirst(2);
            list1.addlast(4);
            list1.addlast(5);
            list1.addlast(9);
            list1.printll();
            System.out.println("");
            list1.LLsize();

        }
    }
