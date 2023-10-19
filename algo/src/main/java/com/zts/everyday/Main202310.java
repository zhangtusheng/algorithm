package com.zts.everyday;

import java.util.Arrays;

/**
 * @author zts
 * @date 2023/10/19 10:03
 * @Description : 10月份
 */
public class Main202310 {

	public static void main(String[] args) {
		Main202310 main = new Main202310();
		System.out.println(main.tupleSameProduct(new int[] {1,2,4,5,10}));
	}


	/**
	 * https://leetcode.cn/problems/tuple-with-same-product/?envType=daily-question&envId=2023-10-19
	 * @param nums
	 * @return
	 */
	public int tupleSameProduct(int[] nums) {
		Arrays.sort(nums);

		int sum = 0;
		for(int i = 0 ;i<nums.length;i++) {
			for (int j = nums.length -1;j>i;j--) {
				int target = nums[i] * nums[j];
				for(int k = i + 1;k<j;k++) {
					int i1 = target % nums[k];
					if (i1 == 0) {
						int value = target / nums[k];
						if (value != nums[k]) {
							int i2 = find(nums, k + 1, j - 1, value);
							if (i2 < j && i2 > k && nums[i2] == value) {
								sum += 8;
							}
						}
					}
				}
			}
		}
		return sum;
	}

	private int find(int[] nums, int start, int end, int target) {
		while (start < end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] < target) start = mid + 1;
			else if (nums[mid] > target) end = mid - 1;
			else return mid;
		}
		return start;
	}
}
