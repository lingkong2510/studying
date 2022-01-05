package com.lyang.studying.algorithm;

import com.lyang.studying.common.ListNode;

/**
 * @author 木子易
 * @version 1.0
 * @date 2021/12/24 9:52 上午
 * @desc 反转列表：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class ReverseList {

    public static ListNode sortList(ListNode head) {
        //如果链表为空，或者只有一个节点，直接返回即可，不用排序
        if (head == null || head.next == null)
            return head;

        //快慢指针移动，以寻找到中间节点
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //找到中间节点，slow节点的next指针，指向mid
        ListNode mid = slow.next;
        //切断链表
        slow.next = null;

        //排序左子链表
        ListNode left = sortList(head);
        //排序左子链表
        ListNode right = sortList(mid);

        //合并链表
        return merge(left, right);
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left != null) {
            temp.next = left;
        } else if (right != null) {
            temp.next = right;
        }
        return head.next;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode o = null;
        ListNode p = head;
        ListNode q = head.next;

        while (p != null) {
            p.next = o;
            o = p;
            p = q;
            if (q == null)
                continue;
            q = q.next;
        }
        return o;
    }

    public static void main(String[] args) {
        ListNode rootNode = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
        ListNode listNode = train2ReverseList(rootNode);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode trainReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = null;
        ListNode pre = head;
        ListNode mid = head.next;

        while (pre != null) {
            pre.next = tail;
            tail = pre;
            pre = mid;
            if (mid == null) continue;
            mid = mid.next;

        }
        return tail;

    }

    public static ListNode train2ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode pre = head;
        ListNode mid = head.next;
        ListNode tail = null;

        while (pre != null) {
            pre.next = tail;
            tail = pre;
            pre = mid;
            if (mid == null) continue;
            mid = mid.next;
        }
        return tail;
    }


}
