package com.dsa.javalearning.stack;

import java.util.ArrayList;

public class Stack_arraylist {
    static class Stack {
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void push(int data) {
            list.add(data);
        }

        public int pop() {
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        public void peek() {
            System.out.println(list.get(list.size() - 1));
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            s.peek();
            s.pop();
        }
    }
}
