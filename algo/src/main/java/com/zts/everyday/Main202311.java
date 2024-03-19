package com.zts.everyday;

import com.alibaba.fastjson.JSON;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.zts.model.TreeNode;
import com.zts.tree.BuilderTree;

/**
 * @Author zhangtusheng
 * @Date 2023 11 16 23 21
 * @describe：
 **/
public class Main202311 {

	public static void main(String[] args) {
		Main202311 main202311 = new Main202311();
		//System.out.println(main202311.vowelStrings(new String[] {"are", "amy", "u"}, 0, 2));
		//System.out.println(JSON.toJSONString(main202311.successfulPairs(new int[] {5,1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
		//System.out.println(main202311.findFirstGreaterOrEqual(new int[]{1,2,3,5,6}, 1));
		//System.out.println(main202311.maximumSum(new int[] {18, 43, 36, 13, 7}));
//		System.out.println(main202311.minDeletion(new int[]{1,1,2,2,3,3}));
//		System.out.println(main202311.minDeletion(new int[]{1,1,2,3,5}));
//		System.out.println(main202311.minDeletion(new int[]{7,14}));
		//System.out.println(main202311.countPairs(List.of(-1, 1, 2, 3, 1), 2));
		Integer[] data = {2,3,5,8,13,21,34};
		TreeNode treeNode = new BuilderTree().buildTree(data);
		main202311.reverseOddLevels(treeNode);
		System.out.println(JSON.toJSONString(treeNode));
		//System.out.println(main202311.pseudoPalindromicPaths(treeNode));
		//System.out.println(main202311.minPathCost(new int[][]{{5,3},{4,0},{2,1}}, new int[][]{{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}}));
		//System.out.println(main202311.sumSubarrayMins(new int[] {11,81,94,43,3}));

	}


	/**
	 * https://leetcode.cn/problems/reverse-odd-levels-of-binary-tree/?envType=daily-question&envId=2023-12-15	 * @param root
	 * @return
	 */
	public TreeNode reverseOddLevels(TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		int index = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<TreeNode> nodes = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				TreeNode left = poll.left;
				if (left != null) {
					queue.offer(left);
					nodes.add(left);
				}
				TreeNode right = poll.right;
				if (right !=null){
					queue.offer(right);
					nodes.add(right);
				}
			}
			if (index % 2==1  && nodes.size() > 0){
				int length = nodes.size();
				for (int i = 0; i < length / 2; i++) {
					TreeNode treeNode = nodes.get(i);
					TreeNode treeNode1 = nodes.get(length - i - 1);
					int value = treeNode.val;
					treeNode.val = treeNode1.val;
					treeNode1.val = value;
				}
			}
			index++;
		}
		return root;
	}


	/**
	 * https://leetcode.cn/problems/sum-of-subarray-minimums/?envType=daily-question&envId=2023-11-27
	 * @param arr
	 * @return
	 */
	public int sumSubarrayMins(int[] arr) {
		int ans = 0;
		int mod = 1000000007;
//		for (int i = 0; i < arr.length; i++) {
//			int mid = arr[i];
//			Map<Integer, Integer> map = new HashMap<>();
//			map.put(mid, 1);
//			for (int j = i + 1 ; j < arr.length; j++) {
//				if (mid > arr[j]) {
//					map.put(arr[j], 1);
//					mid = arr[j];
//				} else {
//					Integer value = map.get(mid);
//					value++;
//					map.put(mid, value);
//				}
//			}
//			long sum = 0;
//			for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
//				sum += (integerIntegerEntry.getKey() * integerIntegerEntry.getValue());
//				sum = sum % mod;
//			}
//			ans = (int) ((ans+sum) % mod);
//		}



		return ans;
	}


	public String simplifyPath(String path) {
		Stack<Character> stack = new Stack<>();
		return path;

	}



	public int pseudoPalindromicPaths (TreeNode root) {
		int[] map = new int[10];
		return dfs(root, map);
	}

	private int dfs(TreeNode root, int[] map){
		if (root == null) {
			return 0;
		}
		map[root.val]++;
		int res = 0;
		if (root.left == null && root.right == null) {
			int count = 0;
			for (int i = 0; i < map.length; i++) {
				if (map[i] % 2 !=0) {
					count++;
				}
				if (count > 1){
					break;
				}
			}
			if (count <=1) {
				res = 1;
			}
		} else {
			res = dfs(root.left, map) + dfs(root.right, map);
		}
		map[root.val]--;
		return res;
	}


	/**
	 * https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/?envType=daily-question&envId=2023-11-24
	 * @param nums
	 * @param target
	 * @return
	 */
	public int countPairs(List<Integer> nums, int target) {
		int ans = 0;
		int length = nums.size();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (nums.get(i) + nums.get(j) < target) {
					ans++;
				}
			}
		}
		return ans;

	}





	/**
	 * https://leetcode.cn/problems/minimum-path-cost-in-a-grid/?envType=daily-question&envId=2023-11-22
	 * @param grid
	 * @param moveCost
	 * @return
	 */
	public int minPathCost(int[][] grid, int[][] moveCost) {
		int length = grid.length;
		int[][] dp = new int[length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < grid[0].length; i++) {
			dp[0][i] = grid[0][i];
		}
		// 第二层开始往下走
		for (int i = 1; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				for (int k = 0; k < grid[0].length; k++) {
					dp[i][j] = Math.min(dp[i][j], moveCost[grid[i-1][k]][j] + dp[i-1][k] + grid[i][j]);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < grid[0].length; i++) {
			min = Math.min(min, dp[length -1][i]);
		}
		return min;
	}



    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "\'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        StringBuilder stringBuilder = new StringBuilder();
        int pos = 0;
        int length = text.length();
        while (pos < length) {
            boolean flag = false;
            if (text.charAt(pos) == '&') {
                Set<Map.Entry<String, String>> entries = map.entrySet();
                for (Map.Entry<String, String> entry : entries) {
                    String e = entry.getKey();
                    String c = entry.getValue();
                    if (pos + e.length() <= length && text.startsWith(e, pos)) {
                        stringBuilder.append(c);
                        flag = true;
                        pos = pos + e.length();
                        break;
                    }
                }
            }
            if (!flag) {
                stringBuilder.append(text.charAt(pos++));
            }
        }
        return stringBuilder.toString();

    }

    public int[] prefix_function(String s) {
        int n = s.length();
        int[] ans = new int[n];
        int len = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                ans[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = ans[len - 1];
                }else {
                    ans[i] = 0;
                    i++;
                }
            }
        }
        return ans;
    }


    /**
     * https://leetcode.cn/problems/maximum-subarray/?envType=daily-question&envId=2023-11-20
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            sum = sum + num > 0 ? sum + num : 0;
            max = Math.max(max, sum);
        }
        return max;
    }


    public int findMinimumOperations(String s1, String s2, String s3) {
        int length = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        // 先从最大长度开始，如果相等的话，就返回他的操作次数。
        int nums = 0;
        String[] strings = {s1, s2, s3};
        Arrays.sort(strings);
        int i =0 ;
        boolean flag = true;
        String target = strings[0].substring(0, length);
        for (i = 0; i < strings.length; i++) {
            if (strings[i].startsWith(target)) {
                if (strings[i].length() != target.length()) {
                    nums++;
                }
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            return nums;
        }
        nums = 0;
        length = strings[0].length() < 3 ? strings[0].length() : 2;
        target = strings[0].substring(length);
        for (i = 0; i < strings.length; i++) {
            if (strings[i].startsWith(target)) {
                if (strings[i].length() != target.length()) {
                    nums++;
                }
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            return nums;
        }
        return -1;


    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int length = nums.length;
        int[] indexs = new int[length];
        for (int i = 0; i < length; i++) {
            indexs[i] = nums[i] % 2;
        }
        int max = 0;
        int currentLength = 0;
        for (int i = 0; i < length; i++) {
            if (currentLength == 0) {
                if (nums[i] <= threshold && indexs[i] == 0) {
                    currentLength++;
                    max = Math.max(max, currentLength);
                }
            }else {
                if ((indexs[i] != indexs[i-1]) && (nums[i] <= threshold)) {
                    currentLength++;
                    max = Math.max(max, currentLength);
                } else if (nums[i]<=threshold && indexs[i] == 0){
                    currentLength = 1;
                    max = Math.max(max, currentLength);
                }else {
                    currentLength = 0;
                }
            }
        }
        return max;
    }


}
