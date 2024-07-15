package com.zts.struct;

import java.util.Arrays;
import java.util.Stack;

import com.zts.model.ListNode;

/**
 * @author zts
 * @date 2024/6/28 10:43
 * @Description
 */
public class MonotonicStack {
	public static void main(String[] args) {
		MonotonicStack monotonicStack = new MonotonicStack();
//		System.out.println(JSON.toJSONString(monotonicStack.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
//		System.out.println(monotonicStack.maxWidthRamp(new int[]{6,0,8,2,1,5}));
		System.out.println(monotonicStack.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}


	/**
	 * https://leetcode.cn/problems/trapping-rain-water/
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < height.length; i++) {
			while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
				int top = stack.pop();
				if (stack.isEmpty()) {
					break;
				}
				int left = stack.peek();
				int currWidth = i - left - 1;
				int currHeight = Math.min(height[left], height[i]) - height[top];
				ans += currHeight * currWidth;
			}
			stack.push(i);
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/maximum-width-ramp/
	 * @param nums
	 * @return
	 */
	public int maxWidthRamp(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = nums.length -1; j > i ; j--) {
				if (nums[i] <= nums[j]) {
					ans = Math.max(ans, j - i);
					break;
				}
			}
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/next-greater-node-in-linked-list/
	 * @param head
	 * @return
	 */
	public int[] nextLargerNodes(ListNode head) {
		Stack<Integer> allValue = new Stack<>();
		while (head != null) {
			allValue.add(head.val);
			head = head.next;
		}
		int[] ans = new int[allValue.size()];
		int n = allValue.size();
		ans[--n] = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(allValue.pop());
		while (!allValue.isEmpty()) {
			while (!stack.isEmpty() && stack.peek() <= allValue.peek()) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				ans[--n] = 0;
			} else {
				ans[--n] = stack.peek();
			}
			stack.push(allValue.pop());
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/next-greater-element-ii/
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] ints = new int[2 * n];
		for (int i = 0; i < n; i++) {
			ints[i] = nums[i];
			ints[i+n] = nums[i];
		}
		int[] ans = new int[n * 2];
		ans[2 * n -1 ] = -1;
		Stack<Integer> stack = new Stack<>();
		stack.push(ints[2 * n - 1]);
		int k = 2 * n - 2;
		while (k >= 0) {
			while (!stack.isEmpty() && stack.peek() <= ints[k]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				ans[k] = -1;
			} else {
				ans[k] = stack.peek();
			}
			stack.push(ints[k]);
			k--;
		}
		int[] result = Arrays.copyOf(ans, n);
		return result;
	}

	/**
	 * https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop/
	 * @param prices
	 * @return
	 */
	public int[] finalPrices(int[] prices) {
		int[] ans = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			ans[i] = prices[i];
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] <= prices[i]) {
					ans[i] -= prices[j];
					break;
				}
			}
		}
		return ans;

	}

	/**
	 * https://leetcode.cn/problems/daily-temperatures/
	 * @param temperatures
	 * @return
	 */
	public int[] dailyTemperatures(int[] temperatures) {
		int n = temperatures.length;
		int[] ans = new int[n];
		Stack<Integer> stack = new Stack<>();
		ans[n - 1] = 0;
		for (int i = n - 1; i >= 0 ; i--) {
			while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
				stack.pop();
			}
			ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return ans;
	}
}
