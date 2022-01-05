package com.lyang.studying.common;

/**
 * @author 木子易
 * @version 1.0
 * @date 2021/12/27 2:41 下午
 * @desc
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
