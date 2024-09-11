package com.gzq.demo.leetcode.每日1题.合并零之间的节点;

public class Solution {
    public static void main(String[] args) {
        ListNode result = new Solution().mergeNodes(new ListNode(0,
                new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0)))))))));
        printList(result);
    }

    // 打印链表方法
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int sum = 0;
        head = head.next; // 跳过第一个 0
        while (head != null) {
            if (head.val == 0) {
                current.next = new ListNode(sum);
                current = current.next;
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return dummy.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
