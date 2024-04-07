package com.zts.model;

/**
 * @author : zhangtusheng
 * @date : 2022/6/29 12:31 PM
 * @description:
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static ListNode createListNode(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int i : arr) {
            current.next = new ListNode(i);
            current = current.next;
        }
        return dummy.next;
    }
}
