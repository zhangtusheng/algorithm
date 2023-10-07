package com.zts.struct;

import com.zts.model.ListNode;

/**
 * @author zts
 * @date 2023/9/30 16:50
 * @Description
 */
public class LinkedTest {


	public int[] reverseBookList(ListNode head) {
		int length = 0;
		ListNode current = head;
		while(current != null) {
			length ++;
			current = current.next;
		}
		int[] result = new int[length];
		current = head;
		int i = 1;
		while(current != null) {
			result[length - i] = current.val;
			current = current.next;
			i++;
		}
		return result;
	}
}
