package com.zts.slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zts
 * @date 2024/6/25 18:26
 * @Description
 */
public class VariableWindowMain {

	public static void main(String[] args) {
		VariableWindowMain main = new VariableWindowMain();
//		System.out.println(main.longestSubarray(new int[] {1, 1, 0, 1}));
//		System.out.println(main.longestSubarray(new int[] {1, 1, 1}));
//		System.out.println(main.totalFruit(new int[] {1, 2, 1}));
//		System.out.println(main.totalFruit(new int[] {1,2,3,2,2}));
//		System.out.println(main.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));

//		System.out.println(main.maxSubarrayLength(new int[] {1,2,3,1,2,3,1,2}, 2));
//		System.out.println(main.maxConsecutiveAnswers("TTFF", 2));
//		System.out.println(main.maxConsecutiveAnswers("TFFT", 1));

//		System.out.println(main.longestSubarray(new int[]{2,4,7,2}, 5));
//		System.out.println(main.longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
//		System.out.println(main.longestNiceSubarray(new int[]{744437702,379056602,145555074,392756761,560864007,934981918,113312475,1090,16384,33,217313281,117883195,978927664}));
//		System.out.println(main.longestNiceSubarray(new int[]{3,1,5,11,13}));
		System.out.println(main.longestNiceSubarray(new int[]{135745088,609245787,16,2048,2097152}));

	}

	public int longestNiceSubarray(int[] nums) {
		int ans = 0;
		for (int left = 0, right = 0, or = 0; right < nums.length; right++) {
			while ((or & nums[right]) > 0) // 有交集
				or ^= nums[left++]; // 从 or 中去掉集合 nums[left]
			or |= nums[right]; // 把集合 nums[right] 并入 or 中
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}



	/**
	 * https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
	 * @param nums
	 * @param limit
	 * @return
	 */
	public int longestSubarray(int[] nums, int limit) {
		int ans = 0;
		int left = 0, right = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		while (right < nums.length) {
			map.merge(nums[right], 1, Integer::sum);
			while (map.lastKey() - map.firstKey() > limit) {
				map.merge(nums[left], -1, Integer::sum);
				if (map.get(nums[left] )== 0) {
					map.remove(nums[left]);
				}
				left++;
			}
			ans = Math.max(ans, right - left + 1);
			right++;
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/max-consecutive-ones-iii/
	 * @param nums
	 * @param k
	 * @return
	 */
	public int longestOnes(int[] nums, int k) {
		int ans = 0;
		int zero = 0;
		int left = 0, right = 0;
		while (right < nums.length) {
			if (nums[right] == 0) {
				zero++;
			}
			while (zero > k) {
				if (nums[left] == 0) {
					zero--;
				}
				left++;
			}
			ans = Math.max(ans, right - left + 1);
			right++;
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/
	 * @param answerKey
	 * @param k
	 * @return
	 */
	public int maxConsecutiveAnswers(String answerKey, int k) {
		int ans = 0;
		int left = 0, right = 0;
		char[] charArray = answerKey.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		while (right < answerKey.length()) {
			map.merge(charArray[right], 1, Integer::sum);
			int min = Math.min(map.getOrDefault('T', 0), map.getOrDefault('F', 0));
			while (min > k) {
				map.merge(charArray[left], -1, Integer::sum);
				left++;
				min = Math.min(map.getOrDefault('T', 0), map.getOrDefault('F', 0));
			}
			ans = Math.max(ans, right - left + 1);
			right++;
		}

		return ans;
	}


	/**
	 * https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/
	 * @param nums
	 * @param k
	 * @return
	 */
	public int maxSubarrayLength(int[] nums, int k) {
		int ans = 0;
		int left = 0, right = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (right < nums.length) {
			map.merge(nums[right], 1, Integer::sum);
			while (map.get(nums[right]) > k) {
				map.merge(nums[left], -1, Integer::sum);
				left++;
			}
			ans = Math.max(ans, right - left + 1);
			right++;
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/maximum-erasure-value/
	 * @param nums
	 * @return
	 */
	public int maximumUniqueSubarray(int[] nums) {
		int ans = 0;
		int left = 0, right = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (right < nums.length) {
			map.merge(nums[right], 1, Integer::sum);
			sum += nums[right];
			while (map.get(nums[right]) > 1) {
				map.merge(nums[left], -1, Integer::sum);
				sum -= nums[left];
				left++;
			}
			right++;
			ans = Math.max(ans, sum);
		}
		return ans;
	}

	/**
	 * https://leetcode.cn/problems/fruit-into-baskets/
	 * @param fruits
	 * @return
	 */
	public int totalFruit(int[] fruits) {
		int ans = 0;
		int left = 0;
		int right = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		while (right < fruits.length) {
			map.merge(fruits[right], 1, Integer::sum);
			if (map.getOrDefault(fruits[right], 0) == 1) {
				count++;
			}
			while (count > 2) {
				map.merge(fruits[left], -1, Integer::sum);
				if (map.getOrDefault(fruits[left], 0) == 0) {
					count--;
				}
				left++;
			}
			ans = Math.max(ans, right - left + 1);
			right++;
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/
	 * @param s
	 * @return
	 */
	public int longestSemiRepetitiveSubstring(String s) {
		return 0;
	}


	/**
	 * https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/
	 */
	public int longestSubarray(int[] nums) {
		int ans = 0;
		int left = 0;
		int right = 0;
		int zeroCount = 0;
		while (right < nums.length) {
			if (nums[right] == 0) {
				zeroCount++;
			}
			right++;
			while (zeroCount > 1) {
				if (nums[left] == 0) {
					zeroCount--;
				}
				left++;
			}
			ans = Math.max(ans, right - left - (zeroCount == 0 ? 1 : zeroCount));
		}
		return ans;
	}
}
