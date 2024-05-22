package com.zts.week;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zts
 * @date 2024/5/21 10:42
 * @Description:https://leetcode.cn/contest/weekly-contest-398/
 */
public class Week398 {

	public static void main(String[] args) {
		Week398 week398 = new Week398();
//		System.out.println(JSON.toJSONString(
//			week398.isArraySpecial(
//				new int[]{4, 3,1,6},
//				new int[][]{ {0, 2}, {2, 3}})
//		));
//
//		System.out.println(JSON.toJSONString(
//			week398.isArraySpecial(
//				new int[]{3,4,1,2,6},
//				new int[][]{ {0, 4}})
//		));

		System.out.println(week398.sumDigitDifferences(new int[] {13, 23, 12}));

	}


	/**
	 *
	 * @param k
	 * @return
	 */
	public int waysToReachStair(int k) {
		return dfs(1, 0, 0, k, new HashMap<>());
	}

	private int dfs(int i, int j, int preDown, int k, Map<Long, Integer> memo) {
		if (i > k + 1) {
			return 0;
		}
		long p = ((long) i << 32) | j << 1 | preDown; // 用一个 long 表示状态
		if (memo.containsKey(p)) { // 之前算过了
			return memo.get(p);
		}
		int res = i == k ? 1 : 0;
		res += dfs(i + (1 << j), j + 1, 0, k, memo); // 操作二
		if (preDown == 0 && i > 0) {
			res += dfs(i - 1, j, 1, k, memo); // 操作一
		}
		memo.put(p, res); // 记忆化
		return res;
	}


	/**
	 * https://leetcode.cn/problems/special-array-i/
	 * @param nums
	 * @return
	 */
	public boolean isArraySpecial(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] % 2 == nums[i-1] % 2) {
				return false;
			}
		}
		return true;
	}


	/**
	 * https://leetcode.cn/problems/special-array-ii/
	 * @param nums
	 * @param queries
	 * @return
	 */
	public boolean[] isArraySpecial(int[] nums, int[][] queries) {
		// 什么时候需要重新计算对应的结果集合。
		boolean[] result = new boolean[queries.length];
		// 影响当前的只有前一个位置的数据，这个时候只需要判断前一个位置是否是奇数或者偶数即可。
		int[] dp = new int[nums.length];
		int[] dpSum = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = nums[i] % 2 == nums[i - 1] % 2 ?  0 : 1;
			dpSum[i] = dpSum[i - 1] + dp[i];
		}
		for (int i = 0; i < queries.length; i++) {
			int[] query = queries[i];
			int left = query[0];
			int right = query[1];
			if (right == left) {
				result[i] = true;
				continue;
			}
			boolean flag = true;
			// 段求和函数。
			int sum = dpSum[right] - dpSum[left];
			if (sum != right - left) {
				flag = false;
			}
			result[i] = flag;
		}
		return result;
	}


	/**
	 * https://leetcode.cn/problems/sum-of-digit-differences-of-all-pairs/
	 * @param nums
	 * @return
	 */
	public long sumDigitDifferences(int[] nums) {
		long ans = 0;
		String[] strings = new String[nums.length];
		String a = String.valueOf(nums[0]);
		int length = a.length();
		Map[] maps = new Map[length];
		for (int i = 0; i < a.length(); i++) {
			maps[i] = new HashMap<Character, Integer>();
		}
		for (int i = 0; i < nums.length; i++) {
			strings[i] = String.valueOf(nums[i]);
			for (int j = 0; j < length; j++) {
				char c = strings[i].charAt(j);
				if (maps[j].get(c) == null) {
					maps[j].put(c, 1);
				} else {
					maps[j].put(c, (int)maps[j].get(c) + 1);
				}
			}
		}

		// 统计ans
		for (int i = 0; i < length; i++) {
			List<Character> list = (List<Character>) maps[i].keySet().stream().collect(Collectors.toList());
			Map<Character, Integer> map = maps[i];
			for (int j = 0; j < list.size() - 1; j++) {
				for (int k = j + 1; k < list.size(); k++) {
					ans += (long) map.get(list.get(j)) * (long)map.get(list.get(k));
				}
			}
		}


		return ans;
	}



}
