package com.dsa.javalearning.linked_list.singly;

public class zExample extends MakingLL {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = lists[0];
        ListNode mainCurr = head;
        int ind = 0;
        for (int i = 1; i < lists.length; i++) {
            ListNode currCurr = lists[i];
            while (mainCurr != null && currCurr != null) {
                if (mainCurr.val < currCurr.val) {
                    mainCurr = mainCurr.next;
                } else {
                    ListNode next = mainCurr.next;
                    mainCurr.next = new ListNode(currCurr.val);
                    mainCurr.next.next = next;
                    currCurr = currCurr.next;
                    mainCurr = mainCurr.next;
                }
            }
            while (currCurr != null) {
                mainCurr = currCurr;
                mainCurr = mainCurr.next;
                currCurr = currCurr.next;
            }
            mainCurr = head;
        }
        return head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevTail = dummy;
        ListNode curr = head;

        while (true) {
            // Check if there are at least k nodes left
            ListNode groupEnd = curr;
            for (int i = 0; i < k; i++) {
                if (groupEnd == null) {
                    // Less than k nodes left, so we're done
                    return dummy.next;
                }
                groupEnd = groupEnd.next;
            }

            // Reverse the k nodes
            ListNode prev = groupEnd;
            ListNode temp = curr;
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect the previous group to the current reversed group
            ListNode newGroupHead = prev;
            prevTail.next = newGroupHead;

            // Move prevTail to the end of the reversed group
            prevTail = temp;
        }
    }

    public static int remainingLength(ListNode curr) {
        int i = 0;
        while (curr != null) {
            curr = curr.next;
            i++;
        }
        return i;
    }


    public static void main(String[] args) {
        MakingLL list1 = new MakingLL();
//        MakingLL list2 = new MakingLL();
//        MakingLL list3 = new MakingLL();
        list1.addFirst(5);
        list1.addFirst(4);
        list1.addFirst(3);
        list1.addFirst(2);
        list1.addFirst(1);
//        list1.printll();
//        System.out.println();
//        list2.printll();
//        System.out.println();
//        list3.printll();
//        System.out.println();
//        ListNode[] listNodes = {list1.head,list2.head,list3.head};
//        printll(mergeKLists(listNodes));
        printll(list1.head);
        System.out.println();
        printll(reverseKGroup(list1.head, 2));
    }
}
