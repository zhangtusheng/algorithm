package com.zts.everyday.d240318;

/**
 * @author zts
 * @date 2024/3/18 14:15
 * @Description: https://leetcode.cn/problems/range-sum-query-immutable/?envType=daily-question&envId=2024-03-18
 */
public class NumArray {

	int[] nums;
	int[] ans;

	public NumArray(int[] nums) {
		this.nums = nums;
		ans = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			ans[i] = sum + nums[i];
			sum = sum + nums[i];
		}
	}

	public int sumRange(int left, int right) {
		int leftSum = 0;
		if (left == 0) {
			leftSum = 0;
		} else {
			leftSum = ans[left - 1];
		}
		return ans[right] - leftSum;
	}
}
