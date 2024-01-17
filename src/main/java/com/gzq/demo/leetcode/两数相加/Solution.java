package com.gzq.demo.leetcode.两数相加;

import java.math.BigInteger;
import java.text.DecimalFormat;

public class Solution {
    private static int[] convertToArray(String number) {
        // 将数字转换为字符串以便逐位获取
        String numberString = String.valueOf(number);

        // 创建数组以容纳每一位
        int[] resultArray = new int[numberString.length()];

        // 逐位获取数字并存储在数组中
        for (int i = 0; i < numberString.length(); i++) {
            resultArray[i] = Character.getNumericValue(numberString.charAt(i));
        }

        return resultArray;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0;
        int j = 0;
        double sum1 = 0;
        double sum2 = 0;
        double sum = 0;
        while (l1 != null) {
            double resultDouble = Math.pow(10, i);
            double sum11 = (int) resultDouble * (l1.val);
            sum1 += sum11;
            l1 = l1.next;
            i = i + 1;
        }
        while (l2 != null) {
            double resultDouble = Math.pow(10, j);
            double sum22 = resultDouble * (l2.val);
            sum2 += sum22;
            l2 = l2.next;
            j = j + 1;
        }

        sum = sum1 + sum2;
        DecimalFormat decimalFormat = new DecimalFormat("#");
        String formattedValue = decimalFormat.format(sum);
        System.out.println(formattedValue);
        int[] resultArray = convertToArray(formattedValue);
        int length = resultArray.length;
        ListNode head = new ListNode(resultArray[length - 1]);
        ListNode current = head;
        for (int m = length - 2; m >= 0; m--) {
            ListNode node = new ListNode(resultArray[m]);
            // 将新节点连接到当前节点后面
            current.next = node;
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(String.format("==%.0f", result.val));
            result = result.next;
        }
    }

}

class ListNode {
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
