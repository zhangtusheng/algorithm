package com.zts.dp;

import java.util.*;

/**
 * @author zts
 * @date 2023/10/13 09:48
 * @Description
 */
public class DpMain {

	public static void main(String[] args) {
		DpMain dpMain = new DpMain();
		//System.out.println(dpMain.minPathSum(new int[][] {{1,2,3},{4,5,6}}));
		//System.out.println(dpMain.maxSales(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		//System.out.println(dpMain.crackNumber(216612));
		//System.out.println(dpMain.crackNumber(506));
//		System.out.println(dpMain.dismantlingAction("tmmzuxt"));
//		System.out.println(dpMain.dismantlingAction("dbascDdad"));
//		System.out.println(dpMain.dismantlingAction("abba"));

		System.out.println(dpMain.nthUglyNumber(10));
	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/9h3im5/
	 * @param n
	 * @return
	 */

	public int nthUglyNumber(int n) {
//		int[] factors = new int[] {2, 3, 5};
//		Set<Long> seen = new HashSet<Long>();
//		PriorityQueue<Long> heap = new PriorityQueue<Long>();
//		seen.add(1L);
//		heap.offer(1L);
//		int ugly = 0;
//		for (int i = 0; i < n; i++) {
//			long curr = heap.poll();
//			ugly = (int) curr;
//			for (int factor : factors) {
//				long next = curr * factor;
//				if (seen.add(next)) {
//					heap.offer(next);
//				}
//			}
//		}
//		return ugly;

		int a = 0, b = 0, c = 0;
		int[] res = new int[n];
		res[0] = 1;
		for(int i = 1; i < n; i++) {
			int n2 = res[a] * 2, n3 = res[b] * 3, n5 = res[c] * 5;
			res[i] = Math.min(Math.min(n2, n3), n5);
			if (res[i] == n2) a++;
			if (res[i] == n3) b++;
			if (res[i] == n5) c++;
		}
		return res[n - 1];

	}

	public boolean isUgly(int num) {
		if (num <= 0) {
			return false; // 负数和零都不是丑数
		}

		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}

		return num == 1; // 如果最终结果等于1，表示是丑数
	}

	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5dgr0c/
	 * @param arr
	 * @return
	 */
	public int dismantlingAction(String arr) {
		// 如果字符串出现过了，当前最大值为dp【i] - dp[i-j];
		// 如果字符串没出现过的话，当前最大值为dp【i】 = dp[i-1] + 1;
		if (arr == null || arr.isEmpty()) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int[] dp = new int[arr.length()];
		dp[0] = 1;
		int max = 1;
		map.put(arr.charAt(0), 0);
		for(int i = 1;i<arr.length();i++) {
			char c = arr.charAt(i);
			if (!map.containsKey(c)) {
				dp[i] = dp[i-1] + 1;
			} else if (map.containsKey(c) && map.get(c) >= start) {
				dp[i] = i - map.get(c) ;
				start = map.get(c) + 1;
			} else if ((map.containsKey(c) && map.get(c) < start)){
				dp[i] = i - start + 1;
			}
			max = Math.max(max, dp[i]);
			map.put(c, i);
		}
		return max;

	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/59gq9c/
	 * @param sales
	 * @return
	 */
	public int maxSales(int[] sales) {
		int[] dp = new int[sales.length];
		dp[0] = sales[0];
		int max = dp[0];
		for(int i = 1;i<sales.length;i++) {
			dp[i] = Math.max(dp[i -1] + sales[i], sales[i]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/57hyl5/
	 * @param num
	 * @return
	 */
	public int trainWays(int num) {
		if (num == 1 || num == 0) {
			return 1;
		}
		int[] f = new int[num + 1];
		f[0] =1;
		f[1] = 1;
		for(int i = 2;i<= num;i++) {
			f[i] = (f[i-1] + f[i-2]) % (1000000007);
		}
		return f[num];
	}

	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/50fxu1/
	 * @param n
	 * @return
	 */
	public int fib(int n) {
		if (n == 1 || n == 0) {
			return n;
		}
		int[] f = new int[n + 1];
		f[0] =0;
		f[1] = 1;
		for(int i = 2;i<=n;i++) {
			f[i] = (f[i-1] + f[i-2]) % (1000000007);
		}
		return f[n];
		//System.out.println(dpMain.minPathSum(new int[][] {{1,2,3},{4,5,6}}));
		//System.out.println(dpMain.bestTiming(new int[] {3, 6, 2, 9, 8, 5}));
	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/99wd55/
	 * @param ciphertext
	 * @return
	 */
	public int crackNumber(int ciphertext) {
//		String s = String.valueOf(ciphertext);
//		if (s.length() == 0) {
//			return 1;
//		}
//		int[] f = new int[]{1, 2, 3, 5, 8, 13, 21, 33, 54, 87, 141};
//		int sum = 1;
//		for(int i = 1;i<s.length();i++) {
//			int start = i;
//			while (i < s.length()) {
//				String c = "" + s.charAt(i - 1) + s.charAt(i);
//				if (Integer.valueOf(c) <= 25 && s.charAt(i-1) != '0') {
//					i++;
//				} else {
//					break;
//				}
//			}
//			if (i != start) {
//				sum = sum * f[i - start];
//			}
//		}
//		return sum;

		int a = 1, b = 1;
		String s = String.valueOf(ciphertext);
		for (int i = s.length()-2; i >=0 ; i--) {
			String tmp = s.substring(i, i + 2);
			int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <=0 ? a + b: a;
			b = a;
			a = c;
		}
		return a;
	}

	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5vokvr/
	 * @param grid
	 * @return
	 */
	public int jewelleryValue(int[][] grid) {
		int[] dp = new int[grid[0].length];
		dp[0] = grid[0][0];
		for(int i = 1;i<grid[0].length;i++) {
			dp[i] = dp[i-1] + grid[0][i];
		}
		for(int i = 1;i<grid.length;i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (j == 0) {
					dp[j] = dp[j] + grid[i][j];
				} else {
					dp[j] = Math.max(dp[j], dp[j-1]) + grid[i][j];
				}
			}
		}
		return dp[grid[0].length - 1];

	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/58nn7r/
	 * @param prices
	 * @return
	 */
	public int bestTiming(int[] prices) {
		if (prices.length ==0 ) {
			return 0;
	    }
		int[] dp = new int[prices.length];
		dp[0] = 0;
		int max = 0;
		int min = prices[0];
		for(int i = 1;i<prices.length;i++) {
			if (prices[i] > min) {
				dp[i] = Math.max(dp[i], prices[i] - min);
			}
			max = Math.max(max, dp[i]);
			min = Math.min(min, prices[i]);
		}
		return max;
	}


	public int minPathSum(int[][] grid) {
		int[] dp = new int[grid[0].length];
		dp[0] = grid[0][0];
		for(int i = 1;i<grid[0].length;i++) {
			dp[i] = dp[i-1] + grid[0][i];
		}
		for(int i = 1;i<grid.length;i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (j == 0) {
					dp[j] = dp[j] + grid[i][j];
				} else {
					dp[j] = Math.min(dp[j], dp[j-1]) + grid[i][j];
				}
			}
		}
		return dp[grid[0].length - 1];
	}




}
