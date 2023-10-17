package com.zts.dp;

/**
 * @author zts
 * @date 2023/10/13 09:48
 * @Description
 */
public class DpMain {

	public static void main(String[] args) {
		DpMain dpMain = new DpMain();
		//System.out.println(dpMain.minPathSum(new int[][] {{1,2,3},{4,5,6}}));
		//System.out.println(dpMain.bestTiming(new int[] {3, 6, 2, 9, 8, 5}));
		System.out.println(dpMain.crackNumber(216612));
	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/99wd55/
	 * @param ciphertext
	 * @return
	 */
	public int crackNumber(int ciphertext) {
		String s = String.valueOf(ciphertext);
		if (s.length() == 0) {
			return 1;
		}
		int[] dp = new int[s.length()];
		int[] f = new int[]{1, 2, 3, 5, 8, 13, 21, 33, 54, 87, 141};

		return dp[s.length() - 1];
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
