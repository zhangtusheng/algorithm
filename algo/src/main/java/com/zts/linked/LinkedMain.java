package com.zts.linked;

import com.alibaba.fastjson.JSON;
import com.zts.model.ListNode;

import java.util.Stack;

/**
 * @Author zhangtusheng
 * @Date 2023 10 13 00 02
 * @describe：
 **/
public class LinkedMain {

    public static void main(String[] args) {

        // [3,6,4,1]
        LinkedMain linkedMain = new LinkedMain();
        ListNode head = new ListNode(1, null);
        ListNode head1 = new ListNode(2, null);
        ListNode head2 = new ListNode(3, null);
        ListNode head3 = new ListNode(4, null);
        ListNode head4 = new ListNode(5, null);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        ListNode listNode = linkedMain.trainingPlan(head, 1);
        System.out.println(JSON.toJSONString(listNode));

    }


    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fvoq2/
     * @param headA
     * @param headB
     * @return
     */
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        int i = 1;
        while (l1 != l2 && i < 4) {
            ListNode next = l1.next;
            if (next==null) {
                i++;
            }
            l1 = next != null ? next : headB;
            ListNode next2 = l2.next;
            if (next2==null) {
                i++;
            }
            l2 = next2 != null ? next2 : headA;
        }
        if (l2 == null) {
            return new ListNode(0);
        }else {
            return l2;
        }
    }


    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fnm66/
     * @param l1
     * @param l2
     * @return
     */
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
        // 哨兵。
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                current.next = l1;
                current = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                current = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return head.next;
    }


    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7f2ng5/
     * @param head
     * @param cnt
     * @return
     */
    public ListNode trainingPlan(ListNode head, int cnt) {
        if (head == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int i = 0;
        while (!stack.isEmpty()) {
            i++;
            ListNode pop = stack.pop();
            if (i == cnt) {
                return pop;
            }
        }
        return null;
    }


    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fadz7/
     * @param head
     * @return
     */
    public ListNode trainningPlan(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode current = head;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            current.next = pop;
            current = pop;
        }
        current.next = null;
        return head;
    }


    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fmls1/
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode current = head.next;

        while(current != null) {
            if (current.val == val) {
                pre.next = current.next;
                break;
            }
            pre = current;
            current = current.next;
        }
        return head;
    }


    public int[] reverseBookList(ListNode head) {
        Stack<Integer> result = new Stack<Integer>();
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        int[] ans = new int[result.size()];
        int i = 0;
        while (!result.isEmpty()) {
            ans[i++] = result.pop();
        }
        return ans;
    }
}
