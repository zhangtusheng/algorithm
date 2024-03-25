package com.zts.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zts.model.TreeNode;

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
//		System.out.println(dpMain2024.maximalSquare(new char[][]{
//			{'1','0','1','0'},
//			{'1','0','1','1'},
//			{'1','0','1','1'},
//			{'1','1','1','1'}
//		}));

//		System.out.println(dpMain2024.longestPalindrome("babad"));
//		System.out.println(dpMain2024.minimumDeleteSum("delete", "leet"));


//		System.out.println(dpMain2024.longestPalindromeSubseq("bbbab"));
//		System.out.println(dpMain2024.minDistance("distance", "springbok"));
//		System.out.println(dpMain2024.minimumDeleteSum("sea", "eat"));
//		System.out.println(dpMain2024.minimumDeleteSum("delete", "leet"));

//		System.out.println(dpMain2024.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
//		System.out.println(dpMain2024.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));

//		System.out.println(dpMain2024.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
//		System.out.println(dpMain2024.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));

//		System.out.println(dpMain2024.longestSubsequence(new int[] {1, 2, 3, 4, 5}, 1));
//		System.out.println(dpMain2024.longestSubsequence(new int[] {1, 3, 5, 7}, 1));
//		System.out.println(dpMain2024.longestSubsequence(new int[] {1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
//		System.out.println(dpMain2024.longestArithSeqLength(new int[] {3, 6, 9, 12}));
//		System.out.println(dpMain2024.maxEnvelopes(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
//		System.out.println(dpMain2024.maxEnvelopes(new int[][] {{1,1}, {1,1}, {1,1}}));
//		System.out.println(dpMain2024.findLongestChain(new int[][]{{1,2}, {2,3}, {3,4}}));

//		System.out.println(dpMain2024.longestCommonSubsequence("abcde", "ace"));
//		System.out.println(dpMain2024.maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
//		System.out.println(dpMain2024.maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
//		System.out.println(dpMain2024.minInsertions("zzazz"));
//		System.out.println(dpMain2024.minInsertions("mbadm"));
//		System.out.println(dpMain2024.minInsertions("leetcode"));
//		System.out.println(JSON.toJSONString(dpMain2024.longestObstacleCourseAtEachPosition(new int[]{1,2,3,2})));
//		System.out.println(dpMain2024.maxProfit(new int[]{1, 2, 3, 0, 2}));
//		System.out.println(dpMain2024.maxProfit(new int[]{1}));
//		System.out.println(dpMain2024.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
//		System.out.println(dpMain2024.numTrees(4));
//		System.out.println(dpMain2024.numTrees(5));
//		System.out.println(dpMain2024.numTrees(3));
//		System.out.println(dpMain2024.numTrees(6));
//		System.out.println(dpMain2024.numSquares(11));
//		System.out.println(dpMain2024.change(5, new int[]{1, 2, 5}));
		System.out.println(dpMain2024.combinationSum4(new int[]{9}, 3));
		System.out.println(dpMain2024.combinationSum4(new int[]{1, 2, 3}, 4));

	}


	/**
	 * https://leetcode.cn/problems/combination-sum-iv/?envType=study-plan-v2&envId=dynamic-programming
	 * @param nums
	 * @param target
	 * @return
	 */
	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		int[] dp = new int[target + 1];
		if (target < nums[0]) {
			return 0;
		}
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i >= nums[j]) {
					dp[i] += dp[i - nums[j]];
				}
			}
		}
		return dp[target];

	}


	/**
	 * https://leetcode.cn/problems/coin-change-ii/?envType=study-plan-v2&envId=dynamic-programming
	 * @param amount
	 * @param coins
	 * @r几点eturn
	 */
	public int change(int amount, int[] coins) {
		int[][] dp = new int[coins.length + 1][amount + 1];
		dp[0][0] = 1;
		Arrays.sort(coins);
		for (int i = 1; i <= coins.length; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= amount ; j++) {
				if (j - coins[i - 1] >= 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[coins.length][amount];
	}

	/**
	 * https://leetcode.cn/problems/perfect-squares/?envType=study-plan-v2&envId=dynamic-programming
	 * @param n:平方整数：通常是用来判断一个数是否为平方数的。
	 * @return
	 */
	public int numSquares(int n) {
		int[] f =  new int[n+1];
		for (int i = 1; i <= n ; i++) {
			int minn = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {

				// 所以数的区间只会出现在1，sqrt（i）之间。
				minn = Math.min(minn, f[i - j * j]);
			}
			// 表示在最小的数上加1
			f[i] = minn + 1;
		}
		return f[n];
	}


	int maxSum = Integer.MAX_VALUE;
	/**
	 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=dynamic-programming
	 * @param root： 构造结点关系。就是从当前结点直接相连的。
	 * @return
	 */
	public int maxPathSum(TreeNode root) {
		maxGain(root);
		return maxSum;
	}

	public int maxGain(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftGain = Math.max(maxGain(root.left), 0);
		int rightGain = Math.max(maxGain(root.right), 0);
		int priceNewPath = root.val + leftGain + rightGain;
		maxSum = Math.max(maxSum, priceNewPath);
		// 当前结点为根结点的最大路径和。
		return root.val + Math.max(leftGain, rightGain);
	}


	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}

		// 优先计算左边的东西，然后在计算右边的东西。
		NewTreeNode dfs = dfs(root);
		return Math.max(dfs.value1, dfs.value2);

	}

	private NewTreeNode dfs(TreeNode root) {
		if (root == null) {
			return new NewTreeNode(0, 0);
		}
		NewTreeNode left = dfs(root.left);
		NewTreeNode right = dfs(root.right);
		NewTreeNode res = new NewTreeNode();
		res.value1 = root.val + left.value2 + right.value2;
		res.value2 = Math.max(left.value1, left.value2) + Math.max(right.value1, right.value2);
		return res;
	}


	private static class NewTreeNode {
		int value1;
		int value2;
		public NewTreeNode(int value1, int value2) {
			this.value1 = value1;
			this.value2 = value2;
		}
		public NewTreeNode() {
		}
	}




	/**
	 * https://leetcode.cn/problems/unique-binary-search-trees-ii/description/?envType=study-plan-v2&envId=dynamic-programming
	 * @param n
	 * @return
	 */
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return new ArrayList<>();
		}
		List<TreeNode> res = new ArrayList<>();
		return buildTreeNode(1, n);
	}

	public List<TreeNode> buildTreeNode(int start, int end) {
		List<TreeNode> allTrees = new LinkedList<>();
		if (start > end) {
			allTrees.add(null);
			return allTrees;
		}

		// 枚举根节点
		for (int i = start; i <= end ; i++) {
			List<TreeNode> leftTrees = buildTreeNode(start, i - 1);
			List<TreeNode> rightTrees = buildTreeNode(i + 1, end);

			// 将两者进行组合。
			for (TreeNode left : leftTrees) {
				for (TreeNode right : rightTrees) {
					TreeNode cur = new TreeNode(i);
					cur.left = left;
					cur.right = right;
					allTrees.add(cur);
				}
			}
		}
		return allTrees;
	}




	/**
	 * https://leetcode.cn/problems/unique-binary-search-trees/?envType=study-plan-v2&envId=dynamic-programming
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		// 如果长度是i，枚举每个以j为跟节点的情况。然后对应的左右子树的个数相乘。因为是搜索树，所以我们知道左子树的个数是j-1，右子树的个数是i-j。
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i ; j++) {
				dp[i] = dp[i] + dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];

	}


	/**
	 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/?envType=study-plan-v2&envId=dynamic-programming
	 * @param prices
	 * @return
	 */
	public int maxProfit2(int[] prices) {
		int n = prices.length;
		int buy1 = -prices[0], sell1 = 0;
		int buy2 = -prices[0], sell2 = 0;
		for (int i = 1; i < n; ++i) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;

	}

	/**
	 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/?envType=study-plan-v2&envId=dynamic-programming
	 * @param prices
	 * @param fee
	 * @return
	 */
	public int maxProfit(int[] prices, int fee) {
		int[][] dp = new int[prices.length][2];
		// 买入
		dp[0][0] = -prices[0];
		// 卖出。
		dp[0][1] = 0;
		for (int i = 1; i < prices.length; i++) {
			// 买入：要么不操作，要么在上次卖出然后买入。。
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
			// 卖出：要么不操作，要么在上次买入然后卖出。
			dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
		}

		return Math.max(dp[prices.length-1][0], dp[prices.length-1][1]);
	}

	/**
	 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/?envType=study-plan-v2&envId=dynamic-programming
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][3];
		dp[0][0] = -prices[0];
		dp[0][1] = 0;
		dp[0][2] = 0;
		for (int i = 1; i < prices.length; i++) {
			// 要么不操作，要么从冷静期买入。
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
			dp[i][1] = dp[i-1][0] + prices[i];
			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
		}
		return Math.max(dp[prices.length-1][1], dp[prices.length-1][2]);
	}


	/**
	 * https://leetcode.cn/problems/find-the-longest-valid-obstacle-course-at-each-position/?envType=study-plan-v2&envId=dynamic-programming
	 * @param obstacles
	 * @return
	 */
	public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
		List<Integer> ls = new ArrayList<>();
		int n = obstacles.length;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			int x = obstacles[i];
			int l = 0, r = ls.size();
			while (l < r) {
				int mid = l + r >> 1;
				if (ls.get(mid) <= x) {
					l = mid + 1;
				} else {
					r = mid;
				}
			}
			if (l == ls.size()) {
				ls.add(x);
			} else {
				ls.set(l, x);
			}
			ans[i] = l + 1;
		}
		return ans;

	}

	/**
	 * https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/?envType=study-plan-v2&envId=dynamic-programming
	 * @param s: 思路是dp[i][j]表示s[j:i]的最少插入次数，如果s[i] == s[j]，则dp[i][j] = dp[i-1][j+1]，否则dp[i][j] = min(dp[i-1][j], dp[i][j+1]) + 1
	 * @return
	 */
	public int minInsertions(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		// dp[i][j] 从j-i的最少操作次数为k
		for (int i = 0; i < n; i++) {
			for (int j = i-1; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i-1][j+1];
				} else {
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j+1]) + 1;
				}
			}
		}
		return dp[n-1][0];
	}


	/**
	 * https://leetcode.cn/problems/uncrossed-lines/?envType=study-plan-v2&envId=dynamic-programming
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int maxUncrossedLines(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int[][] dp = new int[m+1][n+1];
		for (int i = 1; i <=m ; i++) {
			for (int j = 1; j <=n ; j++) {
				if (nums1[i-1] == nums2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}


	/**
	 * https://leetcode.cn/problems/longest-common-subsequence/?envType=study-plan-v2&envId=dynamic-programming
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int longestCommonSubsequence(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int[][] dp = new int[m+1][n+1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}


	/**
	 * https://leetcode.cn/problems/maximum-length-of-pair-chain/?envType=study-plan-v2&envId=dynamic-programming
	 * @param pairs
	 * @return
	 */
	public int findLongestChain(int[][] pairs) {
		int n = pairs.length;
		Arrays.sort(pairs, (a,b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			} else {
				return a[0] - b[0];
			}
		});
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (pairs[i][0] > pairs[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				max = Math.max(max, dp[i]);
			}
		}
		return max;
	}


	/**
	 * https://leetcode.cn/problems/russian-doll-envelopes/?envType=study-plan-v2&envId=dynamic-programming
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, (a, b) -> {
			if (a[0] == b[0]) {
				return b[1] - a[1];
			} else {
				return a[0] - b[0];
			}
		});
		List<Integer> f = new ArrayList<>();
		f.add(envelopes[0][1]);
		for (int i = 1; i < envelopes.length; i++) {
			int num = envelopes[i][1];
			if (num > f.get(f.size() - 1)) {
				f.add(num);
			} else {
				int index = binarySearch(f, num);
				f.set(index, num);
			}

		}
		return f.size();
	}
	// 二分法来查找在范围start, end内，envelop[i][0] < target[0] && envelop[i][1] < target[1]的最大值。
	public int binarySearch(List<Integer> f, int target) {
		int left = 0;
		int right = f.size() - 1;
		while (left < right) {
			int mid = (right - left) / 2 + left;
			if (f.get(mid) < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	/**
	 * https://leetcode.cn/problems/longest-arithmetic-subsequence/description/?envType=study-plan-v2&envId=dynamic-programming
	 * @param nums：枚举所有的差值，然后利用map存储当前节点的最大值。
	 * @return
	 */
	public int longestArithSeqLength(int[] nums) {
		int n = nums.length;
		int ans = 0;
		// 查询两者的最大差值。
		int max = Arrays.stream(nums).max().getAsInt();
		int min = Arrays.stream(nums).min().getAsInt();
		int diff = max - min;
		for (int i = -diff; i <= diff; i++) {
			int difference = i;
			Map<Integer, Integer> map = new HashMap<>();
			for (int v : nums) {
				int u = v - difference;
				// 如果u存在的话，就存当前节点。如果不存在就存储1就好了。
				map.put(v, map.getOrDefault(u, 0) + 1);
				ans = Math.max(ans, map.get(v));
			}
		}
		return ans;
	}

	/**
	 * https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/?envType=study-plan-v2&envId=dynamic-programming
	 * @param arr: 其实当前节点如果定了话，那么就能从这个节点开始找到前一个节点的指针。
	 * @param difference
	 * @return
	 */
	public int longestSubsequence(int[] arr, int difference) {
		Map<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		// 对于当前节点来说，我们只需要保证v-difference的节点存在，并且是最大的，就能保证当前节点v也是最大的。
		for (int v : arr) {
			int u = v -difference;
			// 如果u存在的话，就存当前节点。如果不存在就存储1就好了。
			map.put(v, map.getOrDefault(u, 0) + 1);
			ans = Math.max(ans, map.get(v));
		}
		return ans;

	}

	/**
	 * https://leetcode.cn/problems/number-of-longest-increasing-subsequence/?envType=study-plan-v2&envId=dynamic-programming
	 * @param nums
	 * @return
	 */
	public int findNumberOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i ; j++) {
				if (nums[i] >= nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 1;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] == max - 1) {
				for (int j = i + 1; j < n; j++) {
					if (nums[i] <= nums[j]) {
						ans++;
					}
				}
			}
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/longest-increasing-subsequence/?envType=study-plan-v2&envId=dynamic-programming
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i ; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 1;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

	/**
	 * https://leetcode.cn/problems/distinct-subsequences/?envType=study-plan-v2&envId=dynamic-programming
	 * @param s
	 * @param t
	 * @return
	 */
	public int numDistinct(String s, String t) {
		return 0;
	}


	/**
	 * https://leetcode.cn/problems/minimum-ascii-delete-sum-for-two-strings/?envType=study-plan-v2&envId=dynamic-programming
	 * @param s1
	 * @param s2
	 * 逻辑：利用dp【i][j]表示s1的前i个字符和s2的前j个字符的最小删除和。
	 * @return
	 */
	public int minimumDeleteSum(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= s1.length(); i++) {
			dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
		}
		for (int i = 1; i <= s2.length(); i++) {
			dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
		}
		for (int i = 1; i <= s1.length(); i++) {
			int code1 = s1.codePointAt(i - 1);
			for (int j = 1; j <= s2.length(); j++) {
				int code2 = s2.codePointAt(j - 1);
				if (code1 == code2) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j] + code1, dp[i][j - 1] + code2);
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
	/**
	 * https://leetcode.cn/problems/edit-distance/?envType=study-plan-v2&envId=dynamic-programming
	 * @param word1
	 * @param word2
	 * @return
	 */
	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		int n = word1.length(), m = word2.length();
		if (n * m == 0) {
			return n + m;
		}
		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= word2.length(); i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}



	/**
	 * https://leetcode.cn/problems/longest-palindromic-subsequence/?envType=study-plan-v2&envId=dynamic-programming
	 * @param s： 其实就是求解前后两个最大的回文串之和。
	 * @return
	 */
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			dp[i][i] = 1;
			char c1 = s.charAt(i);
			for (int j = i + 1; j < n; j++) {
				char c2 = s.charAt(j);
				if (c1 == c2) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][n - 1];
	}


	/**
	 * https://leetcode.cn/problems/word-break/?envType=study-plan-v2&envId=dynamic-programming
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		Set<String> wordDictSet = new HashSet<>(wordDict);
		dp[0] = true;
		for (int i = 0; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	/**
	 * https://leetcode.cn/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=dynamic-programming
	 * @param s：马拉车算法。
	 * @return
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private int expandAroundCenter(String s, int left, int right) {
		int L = left, R = right;
		while ( L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
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
