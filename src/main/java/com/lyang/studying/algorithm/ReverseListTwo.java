package com.lyang.studying.algorithm;

import com.lyang.studying.common.ListNode;

/**
 * @author 木子易
 * @version 1.0
 * @date 2021/12/29 4:36 下午
 * @desc 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class ReverseListTwo {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
       if (left >= right)return head;

       ListNode newNode = new ListNode();
       newNode.next = head;
       ListNode leftNode = newNode,rightNode = newNode;

       while (--left != 0){
           leftNode = leftNode.next;
       }

       while (right-- != 0){
           rightNode = rightNode.next;
       }
       ListNode tail = rightNode.next;
       rightNode.next = null;
       leftNode.next = reverseList(leftNode.next,tail);
        return newNode.next;
    }

    public static ListNode reverseList(ListNode head , ListNode tail){
       ListNode pre = head;
       ListNode mid = head.next;
       while (pre != null){
           pre.next = tail;
           tail = pre;
           pre = mid;
           if (mid == null)continue;
           mid = mid.next;
       }
       return tail;

    }

    public static void main(String[] args) {
        ListNode rootNode = new ListNode(6,new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1))))));
        ListNode listNode = reverseBetween2(rootNode,2,4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode reverseBetween2(ListNode head,int left , int right){
        if (left >= right)return head;
        ListNode newNode = new ListNode();
        newNode.next = head;
        ListNode leftNode = newNode,rightNode = newNode;

        while (--left != 0){
            leftNode = leftNode.next;
        }

        while (right-- != 0){
            rightNode = rightNode.next;
        }
        ListNode tail = rightNode.next;
        rightNode.next = null;

        leftNode.next = middleReverse(leftNode.next,tail);

        return newNode.next;

    }

    public static ListNode middleReverse(ListNode head,ListNode tail){
        ListNode pre = head,mid = head.next;

        while (pre != null){
            pre.next = tail;
            tail = pre;
            pre = mid;
            if (mid != null){
                mid = mid.next;
            }
        }
        return tail;
    }
}
