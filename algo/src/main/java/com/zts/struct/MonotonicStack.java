package com.zts.struct;

import java.util.Stack;

import com.alibaba.fastjson.JSON;

/**
 * @author zts
 * @date 2024/6/28 10:43
 * @Description
 */
public class MonotonicStack {
	public static void main(String[] args) {
		MonotonicStack monotonicStack = new MonotonicStack();
		System.out.println(JSON.toJSONString(monotonicStack.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
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
