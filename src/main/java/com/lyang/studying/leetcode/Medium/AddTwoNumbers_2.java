package com.lyang.studying.leetcode.Medium;


import com.lyang.studying.common.ListNode;

/**
 * @author 木子易
 * @version 1.0
 * @date 2022/2/24 2:33 下午
 * @desc [2] 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
 * ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * ListNode l1 = new ListNode(0);
 * ListNode l2 = new ListNode(0);
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers_2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9
                , new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        StringBuilder s = new StringBuilder();
        for (ListNode listNode = addTwoNumbers(l1, l2); listNode != null; listNode = listNode.next) {
            s.append(listNode.val);
        }
        System.out.println(s);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null){
            int val1 = l1 == null ? 0:l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            if (head == null){
                head = new ListNode(sum % 10);
                tail = head;
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            if (l1 != null){
                l1 = l1.next;
            }

            if (l2 != null){
                l2 = l2.next;
            }

            carry = sum / 10;
        }
        if (carry > 0){
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode next1 = l1.next;
        ListNode next2 = l2.next;
        int value1 = l1.val;
        int value2 = l2.val;
        int v = (value1 + value2) % 10;
        int weight = (value1 + value2) / 10;
        ListNode root = new ListNode(v);
        ListNode node = root;
        while (next1 != null && next2 != null) {
            int val1 = next1.val;
            int val2 = next2.val;
            int value = (val1 + val2 + weight) % 10;
            weight = (val1 + val2 + weight) / 10;
            node.next = new ListNode(value);
            node = node.next;
            next1 = next1.next;
            next2 = next2.next;
        }

        if (next1 == null) {
            while (next2 != null) {
                int nextVal = (weight + next2.val) % 10;
                weight = (weight + next2.val) / 10;
                node.next = new ListNode(nextVal);
                next2 = next2.next;
                node = node.next;
            }
        } else {
            while (next1 != null) {
                int nextVal = (weight + next1.val) % 10;
                weight = (weight + next1.val) / 10;
                node.next = new ListNode(nextVal);
                next1 = next1.next;
                node = node.next;
            }
        }
        if (weight != 0){
            node.next = new ListNode(weight);
        }
        return root;
    }


}
