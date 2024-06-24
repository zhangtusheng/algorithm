package com.zts.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zts.model.TreeNode;

/**
 * @author zts
 * @date 2024/6/24 18:04
 * @Description
 */
public class Top100 {

	public static void main(String[] args) {
		Top100 top100 = new Top100();
//		System.out.println(JSON.toJSONString(top100.partitionLabels("ababcbacadefegdehijhklij")));
//		BuilderTree builderTree = new BuilderTree();
//		TreeNode treeNode = builderTree.buildTree(new Integer[] {1, 2, 3, 4, 5});
//		System.out.println(top100.diameterOfBinaryTree(treeNode));

//		System.out.println(JSON.toJSONString(top100.productExceptSelf(new int[]{1, 2, 3, 4})));
//		System.out.println(JSON.toJSONString(top100.productExceptSelf(new int[]{-1,1,0,-3,3})));
//		System.out.println(top100.firstMissingPositive(new int[]{1, 2, 0}));
//		System.out.println(top100.firstMissingPositive(new int[]{0, 1, 1, 2, 2}));
	}


	/**
	 * https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked
	 * @param nums
	 * @return
	 */
	public int firstMissingPositive(int[] nums) {
		Arrays.sort(nums);
		int current = 1;
		int right = 0;
		while (right < nums.length) {
			if (nums[right] <= 0) {
				right++;
				continue;
			}
			if (nums[right] != current) {
				return current;
			}
			// 进行处理
			right++;
			while (right < nums.length && nums[right] == current) {
				right++;
			}
			current++;
		}
		return current;

	}

	/**
	 * https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-100-liked
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int ans = 1;
		int[] result = new int[nums.length ];
		int[] preSum = new int[nums.length + 1];
		int[] suffixSum = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			ans = ans * nums[i];
			preSum[i + 1] = ans;
		}
		preSum[0] = 1;
		ans = 1;
		suffixSum[nums.length] = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			ans = ans * nums[i];
			suffixSum[i] = ans;
		}
		for (int i = 0; i < nums.length; i++) {
			result[i] = preSum[i] * suffixSum[i + 1];
		}
		return result;
	}


	/**
	 * https://leetcode.cn/problems/diameter-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked
	 * @param root
	 * @return
	 */
	int maxTreeLenght =0;
	public int diameterOfBinaryTree(TreeNode root) {
		maxTreeLenght = 0;
		maxLength(root);
		return maxTreeLenght;
	}

	public int maxLength(TreeNode root){
		if(root == null){
			return 0;
		}

		// 左边高度
		int maxLeftResult = maxLength(root.left);
		// 右边高度。
		int maxRightResult = maxLength(root.right);
		// 当前节点的最长路径是多少，进行更新。
		int max = 0;
		if (root.left != null) {
			max = max + maxLeftResult;
		}
		if (root.right != null) {
			max = max + maxRightResult;
		}
		maxTreeLenght = Math.max(maxTreeLenght, max);
		return Math.max(maxLeftResult, maxRightResult) + 1;
	}

	/**
	** https://leetcode.cn/problems/partition-labels/?envType=study-plan-v2&envId=top-100-liked
	 */
	public List<Integer> partitionLabels(String s) {
		// 用来记录对应的字符的最后位置。
		Map<Character, Integer> map = new HashMap<>();
		int[] windows = new int[26];
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		int left = 0, right = 0;
		int n = s.length();
		char[] charArray = s.toCharArray();
		List<Integer> result = new ArrayList<>();
		while (right < n) {
			// 判断left - right直接是否合法的。
			windows[charArray[right] - 'a']++;
			boolean isCorrect = true;
			for (int i = 0; i < 26; i++) {
				if (windows[i] != 0) {
					char key = (char) (i + 'a');
					Integer i1 = map.get(key);
					if (i1 > right) {
						isCorrect = false;
						break;
					}
				}
			}
			// 如果是合法的，那么就进行left的迁移。
			if (isCorrect) {
				Arrays.fill(windows, 0);
				// 填充区间；
				result.add(right - left + 1);
				left = right + 1;
			}
			right++;
		}
		return result;

	}
}
