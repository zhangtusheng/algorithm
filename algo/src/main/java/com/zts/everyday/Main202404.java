package com.zts.everyday;

import java.util.Stack;

import com.alibaba.fastjson.JSON;
import com.zts.model.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zts
 * @date 2024/4/7 11:10
 * @Description
 */
@Slf4j
public class Main202404 {

	public static void main(String[] args) {
		Main202404 main202404 = new Main202404();
		System.out.println(JSON.toJSONString(main202404.reverseKGroup(ListNode.createListNode(new int[] { 1, 2, 3, 4, 5 }), 2)));
		System.out.println(JSON.toJSONString(main202404.reverseKGroup(ListNode.createListNode(new int[] { 1, 2, 3, 4, 5 }), 3)));
		System.out.println(JSON.toJSONString(main202404.reverseKGroup(ListNode.createListNode(new int[] { 1, 2}), 2)));
	}


	/**
	 * https://leetcode.cn/problems/number-of-employees-who-met-the-target/?envType=daily-question&envId=2024-04-30
	 * @param hours
	 * @param target
	 * @return
	 */
	public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
		int result = 0;
		for (int hour : hours) {
			if (hour >= target) {
				result++;
			}
		}
		return result;
	}

	/**
	 * K链表反转。
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		Stack<ListNode> stack = new Stack<>();
		ListNode dummy = new ListNode(0);
		ListNode current = head;
		ListNode tail = dummy;
		while (current != null) {
			stack.push(current);
			ListNode next = current.next;
			current.next = null;
			current = next;
			if (stack.size() == k) {
				while (!stack.isEmpty()) {
					tail.next = stack.pop();
					tail = tail.next;
				}
			}
		}
		if (!stack.isEmpty()) {
			tail.next = null;
			while (!stack.isEmpty()) {
				ListNode pop = stack.pop();
				pop.next = tail.next;
				tail.next = pop;
			}
		}
		return dummy.next;
	}
}
