package com.zts.other;

import com.zts.model.ListNode;

/**
 * @author zts
 * @date 2023/9/28 18:04
 * @Description
 */
public class Solution {

	int[] nums;

	ListNode head;

	public Solution(int[] nums) {
		this.nums = nums;
		ListNode head = new ListNode(nums[0]);
		ListNode preNode = head;
		for(int i = 1;i<nums.length;i++) {
			ListNode current = new ListNode(nums[i]);
			preNode.next = current;
			preNode = current;
		}
	}

	public int[] reset() {
		ListNode head = new ListNode(nums[0]);
		ListNode preNode = head;
		for(int i = 1;i<nums.length;i++) {
			ListNode current = new ListNode(nums[i]);
			preNode.next = current;
			preNode = current;
		}
		return nums;
	}

	public int[] shuffle() {
		int[] result = new int[nums.length];
		int i1 = nums.length - 1;
		for(int i = i1; i>=0; i--) {
			result[i1 - i] = nums[i];
		}
		return result;
	}


}
