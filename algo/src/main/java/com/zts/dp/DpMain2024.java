package com.zts.dp;

/**
 * @author zts
 * @date 2024/3/18 19:46
 * @Description: 2024dp专题：https://leetcode.cn/studyplan/dynamic-programming/
 */
public class DpMain2024 {

	public static void main(String[] args) {
		DpMain2024 dpMain2024 = new DpMain2024();
		System.out.println(dpMain2024.minCostClimbingStairs(new int[]{10, 15, 100}));
		System.out.println(dpMain2024.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
	}

	/**
	 * https://leetcode.cn/problems/house-robber/?envType=study-plan-v2&envId=dynamic-programming
	 * @param nums
	 * @return
	 */
	public int rob(int[] nums) {
		int[][] dp = new int[2][nums.length];
		dp[0][0] = 0;
		dp[1][0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
			dp[1][i] = dp[0][i-1] + nums[i];
		}
		return Math.max(dp[0][nums.length - 1], dp[1][nums.length - 1]);
	}

	/**
	 * https://leetcode.cn/problems/min-cost-climbing-stairs/?envType=study-plan-v2&envId=dynamic-programming
	 * @param cost
	 * @return
	 */
	public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length + 1];
		dp[1] = cost[0];
		if (cost.length == 1){
			return 0;
		}
		dp[2] = cost[1];
		for (int i = 3; i <= cost.length; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i-1], dp[i-2] + cost[i-1]);
		}
		return Math.min(dp[cost.length], dp[cost.length - 1]);
	}

	/**
	 * https://leetcode.cn/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=dynamic-programming
	 * @param n
	 * @return
	 */
	public int tribonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}

	/**
	 * https://leetcode.cn/problems/fibonacci-number/?envType=study-plan-v2&envId=dynamic-programming
	 * @param n
	 * @return
	 */
	public int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	/**
	 * https://leetcode.cn/problems/climbing-stairs/submissions/513554800/?envType=study-plan-v2&envId=dynamic-programming
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
