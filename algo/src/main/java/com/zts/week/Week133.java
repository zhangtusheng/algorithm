package com.zts.week;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zts
 * @date 2024/6/24 11:14
 * @Description
 */
public class Week133 {

	public static void main(String[] args) {
		Week133 week133 = new Week133();
//		System.out.println(week133.minOperations(new int[] {0, 1, 1, 1, 0, 0}));
//		System.out.println(week133.minOperations(new int[] {0,1,1,1}));
		System.out.println(week133.minOperations(new int[] {1,0,0,1,1,1,0,1,1,1}));
	}


	/**
	 * https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-ii/description/
	 * @param nums
	 * @return
	 */
	public int minOperations(int[] nums) {
		int ans = 0;
		int right = 0;
		List<Integer[]> indexList = new ArrayList<>();
		while (right < nums.length) {
			if (nums[right] == 1) {
				right++;
				continue;
			}
			int i = right;
			for (; i < nums.length; i++) {
				if (nums[i]!=0) {
					break;
				}
			}
			indexList.add(new Integer[]{right, i - 1});
			right = i;
		}
		for (int i = 0; i < indexList.size(); i++) {
			Integer[] integers = indexList.get(i);
			// 判断是否到尾端节点。
			Integer end = integers[1];
			if (end < nums.length - 1) {
				ans += 2;
			} else {
				ans ++;
			}
		}
		return ans;
	}

	/**
	 * https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/
	 * @param nums： 滑动窗口翻转。
	 * @return
	 */
	public int minOperations1(int[] nums) {
		int ans = 0;
		int left = 0, right = 0;
		int n = nums.length;
		while (right < n) {
			if (right - left + 1 == 3) {
				// 判断是否需要翻转。
				boolean containsZero = false;
				for (int i = left; i <= right ; i++) {
					if (nums[i] == 0) {
						containsZero = true;
					}
					nums[i] = ~nums[i] & 1;
				}
				if (containsZero) {
					ans++;
				}
				for (int i = left; i <= right; i++) {
					if (nums[left] == 1) {
						left++;
					} else {
						break;
					}
				}
			}
			if (left == right && nums[left] == 1) {
				left++;
			}
			right++;
		}
		boolean containsZero = false;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				containsZero = true;
			}
		}
		if (containsZero) {
			return -1;
		}
		return ans;
	}
}
