package com.zts.dp;

/**
 * @author zts
 * @date 2023/10/13 09:48
 * @Description
 */
public class DpMain {

	public static void main(String[] args) {
		DpMain dpMain = new DpMain();
		System.out.println(dpMain.minPathSum(new int[][] {{1,2,3},{4,5,6}}));
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
