package com.zts.week;

import java.util.Arrays;

/**
 * @author zts
 * @date 2024/4/12 11:13
 * @Description:https://leetcode.cn/contest/weekly-contest-392/
 */
public class Week392 {

	public static void main(String[] args) {
		Week392 week392 = new Week392();
//		System.out.println(week392.longestMonotonicSubarray(new int[] {3, 2, 1}));
//		System.out.println(week392.longestMonotonicSubarray(new int[] {1, 4, 3, 3, 2}));
		System.out.println(week392.getSmallestString("lol", 0));
		System.out.println(week392.getSmallestString("xaxcd", 4));
		System.out.println(week392.getSmallestString("zbbz", 3));
	}


	/**
	 * 先排序，然后找到中间的数，如果偶数，那么中间的数是中间两个数的平均值。
	 * @param nums
	 * @param k
	 * @return
	 */
	public long minOperationsToMakeMedianK(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;
		long sum = 0;
		if (n % 2== 0) {
			// 如果当前中间两个值中，最大的一个是k，那么操作是就是0；
			if (nums[n / 2] == k) {
				return 0;
			}
		} else {

		}

		return 1;
	}


	/**
	 *
	 * @param s
	 * @param k
	 * @return
	 */
	public String getSmallestString(String s, int k) {
		// z = 'a'距离是1，如果当前剩余的t不能让变成a，那就跳过。贪心算法。
		int nums = k;
		String result = "";
		char[] charArray = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (charArray[i] == 'a') {
				result += 'a';
				continue;
			}
			// 看看当前节点跳到a需要多少步。// 如果不能的话，就进行尽量往前靠。但是不能靠到头。
			int t = charArray[i] - 'a';
			int t1 = 'z' - charArray[i];
			if (nums > t1) {
				if (t1 < t) {
					result += 'a';
					nums -= t1 + 1;
				} else {
					result += 'a';
					nums -= t;
				}
			} else {
				// 查看能往前跳多少步。
				if (t < nums) {
					result += 'a';
					nums -= t;
				} else {
					result += (char) (charArray[i] - nums);
					nums = 0;
				}
			}

		}
		return result;
	}


	/**
	 * 最长递增或者递减子数组。
	 * @param nums
	 * @return
	 */
	public int longestMonotonicSubarray(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		int[] dp2 = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(dp2, 1);
		int max = 1;
		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			}
			if (nums[i] < nums[i - 1]) {
				dp2[i] = dp2[i - 1] + 1;
			}
			max = Math.max(max, Math.max(dp[i], dp2[i]));
		}
		return max;
	}

}
