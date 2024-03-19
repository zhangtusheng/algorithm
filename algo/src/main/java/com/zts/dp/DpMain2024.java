package com.zts.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author zts
 * @date 2024/3/18 19:46
 * @Description: 2024dp专题：https://leetcode.cn/studyplan/dynamic-programming/
 */
public class DpMain2024 {

	public static void main(String[] args) {
		DpMain2024 dpMain2024 = new DpMain2024();
//		System.out.println(dpMain2024.minCostClimbingStairs(new int[]{10, 15, 100}));
//		System.out.println(dpMain2024.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
		//System.out.println(dpMain2024.deleteAndEarn(new int[] {2, 2, 3, 3, 3, 4}));
//		System.out.println(dpMain2024.uniquePaths(3, 7));
//		System.out.println(dpMain2024.uniquePaths(3, 2));

		//System.out.println(dpMain2024.minPathSum(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
//		System.out.println(dpMain2024.uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
//		System.out.println(dpMain2024.uniquePathsWithObstacles(new int[][] {{0, 1} ,{ 0, 0}}));
//		System.out.println(dpMain2024.uniquePathsWithObstacles(new int[][] {{1}}));

//		System.out.println(dpMain2024.minimumTotal(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3))));
//		System.out.println(dpMain2024.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
//		System.out.println(dpMain2024.maximalSquare(new char[][]{{'1', '0'}, {'1', '0'}}));
		System.out.println(dpMain2024.maximalSquare(new char[][]{
			{'1','0','1','0'},
			{'1','0','1','1'},
			{'1','0','1','1'},
			{'1','1','1','1'}
		}));

	}

	/**
	 * https://leetcode.cn/problems/maximal-square/?envType=study-plan-v2&envId=dynamic-programming
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int[][] dpRow = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (j == 0) {
						dpRow[i][j] = 1;
					} else {
						dpRow[i][j] = dpRow[i][j - 1] + 1;
					}
				} else {
					dpRow[i][j] = 0;
				}
			}
		}
		int[][] dpCol = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0) {
						dpCol[i][j] = 1;
					} else {
						dpCol[i][j] = dpCol[i - 1][j] + 1;
					}
				} else {
					dpCol[i][j] = 0;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						// 如果对角线上的点不为0的话，特殊处理下。
						if (dp[i-1][j-1] != 0) {
							int min = Math.min(dpRow[i][j-1], dpCol[i-1][j]);
							int diagonal = (int) Math.sqrt(dp[i-1][j-1]);
							min = Math.min(min, diagonal);
							dp[i][j] = (min + 1) * (min + 1);
						} else {
							dp[i][j] = 1;
						}
					}
					max = Math.max(max, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return max;
	}

	/**
	 * https://leetcode.cn/problems/minimum-falling-path-sum/?envType=study-plan-v2&envId=dynamic-programming
	 * @param matrix
	 * @return
	 */
	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[0][i] = matrix[0][i];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + matrix[i][j];
				} else if (j == n-1) {
					dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + matrix[i][j];
				} else {
					dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1])) + matrix[i][j];
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, dp[n-1][i]);
		}
		return min;
	}

	/**
	 * https://leetcode.cn/problems/triangle/?envType=study-plan-v2&envId=dynamic-programming
	 *
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
				}else if (j == triangle.get(i).size() - 1) {
					dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
				} else {
					dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(min, dp[n-1][i]);
		}
		return min;
	}

	/**
	 * https://leetcode.cn/problems/unique-paths-ii/?envType=study-plan-v2&envId=dynamic-programming
	 * @param obstacleGrid ： 如果当前节点是1的话，表示这个是障碍物，那么当前节点的路径和为0.
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = obstacleGrid[0][0] == 1? 0: 1;
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				dp[i][0] = 0;
			} else {
				dp[i][0] = dp[i-1][0];
			}
		}
		for (int i = 1; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				dp[0][i] = 0;
			} else {
				dp[0][i] = dp[0][i-1];
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		return dp[m-1][n-1];
	}

	/**
	 * https://leetcode.cn/problems/minimum-path-sum/?envType=study-plan-v2&envId=dynamic-programming
	 * @param grid: 最小路径和。
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = dp[0][i-1] + grid[0][i];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}
		return dp[m-1][n-1];
	}

	/**
	 * https://leetcode.cn/problems/unique-paths/?envType=study-plan-v2&envId=dynamic-programming
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}


	/**
	 * https://leetcode.cn/problems/delete-and-earn/?envType=study-plan-v2&envId=dynamic-programming
	 * @param nums:关键思路：跟打劫家舍的方式类似，主要是要现将相同的数字进行预处理。然后取数字的时候，利用连续的数组下标来进行取数，对于当前节点来说，能取数的只有两种情况，就是当前节点取跟不取。然后在进行前节点的判断。
	 * @return
	 */
	public int deleteAndEarn(int[] nums) {
		int maxVal = 0;
		for (int val : nums) {
			maxVal = Math.max(maxVal, val);
		}
		int[] sum = new int[maxVal + 1];
		// 统计每个val的总和，相同的为一组，并且想加。
		for (int val : nums) {
			sum[val] += val;
		}
		return rob1(sum);
	}

	public int rob1(int[] nums) {
		int size = nums.length;
		int first = nums[0], second = Math.max(nums[0], nums[1]);
		for (int i = 2; i < size; i++) {
			int temp = second;
			second = Math.max(first + nums[i], second);
			first = temp;
		}
		return second;
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
