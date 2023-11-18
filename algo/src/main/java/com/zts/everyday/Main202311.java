package com.zts.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zts
 * @date 2023/11/7 11:33
 * @Description
 */
public class Main202311 {

	public static void main(String[] args) {
		Main202311 main202311 = new Main202311();
		//System.out.println(main202311.vowelStrings(new String[] {"are", "amy", "u"}, 0, 2));
		//System.out.println(JSON.toJSONString(main202311.successfulPairs(new int[] {5,1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
		//System.out.println(main202311.findFirstGreaterOrEqual(new int[]{1,2,3,5,6}, 1));
		System.out.println(main202311.maximumSum(new int[] {18, 43, 36, 13, 7}));
	}

	/**
	 * https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/?envType=daily-question&envId=2023-11-18
	 * @param nums
	 * @return
	 */
	public int maximumSum(int[] nums) {
		int length = nums.length;
		int[] sum = new int[length];
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			sum[i] = bitSum(nums[i]);
			PriorityQueue<Integer> currentQueue = map.get(sum[i]);
			if (currentQueue !=null) {
				currentQueue.offer(nums[i]);
			} else {
				PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
				queue.offer(nums[i]);
				map.put(sum[i], queue);
			}
		}
		int max = -1;
		for (Map.Entry<Integer, PriorityQueue<Integer>> queueEntry : map.entrySet()) {
			PriorityQueue<Integer> value1 = queueEntry.getValue();
			if (value1.size() >= 2) {
				int value = value1.poll() + value1.poll();
				max = Math.max(value, max);
			}
		}
		return max;
	}

	private int bitSum(int value) {
		int sum = 0;
		while (value > 0) {
			sum += value % 10;
			value = value / 10;
		}
		return sum;
	}

	/**
	 * https://leetcode.cn/problems/longest-even-odd-subarray-with-threshold/?envType=daily-question&envId=2023-11-16
	 * @param nums
	 * @param threshold
	 * @return
	 */
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


	/**
	 * https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/?envType=daily-question&envId=2023-11-10
	 * @param spells
	 * @param potions
	 * @param success
	 * @return
	 */
	public int[] successfulPairs(int[] spells, int[] potions, long success) {
		int[] result = new int[spells.length];
		Arrays.sort(potions);
		// 利用二分法来查找。
		int length = spells.length;
		int pLength = potions.length;
		for (int i = 0; i < length; i++) {
			int spell = spells[i];
			long value = (long)Math.ceil(success / (spell * 1.0));
			int index = findFirstGreaterOrEqual(potions, value);
			if (index < 0) {
				result[i] = 0;
			} else {
				result[i] = pLength - index;
			}
		}
		return result;

	}

	public int findFirstGreaterOrEqual(int[] arr, long target) {
		int left = 0;
		int right = arr.length - 1;
		int resultIndex = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] >= target) {
				// 当当前元素大于等于目标值时，更新结果并继续在左半边查找
				resultIndex = mid;
				right = mid - 1;
			} else {
				// 当当前元素小于目标值时，在右半边查找
				left = mid + 1;
			}
		}

		return resultIndex;
	}

	/**
	 * https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/?envType=daily-question&envId=2023-11-07
	 * @param words
	 * @param left
	 * @param right
	 * @return
	 */
	public int vowelStrings(String[] words, int left, int right) {
		int ans = 0;
		Map<Character, Character> map = new HashMap<>();
		map.put('a', 'a');
		map.put('e', 'e');
		map.put('i', 'i');
		map.put('o', 'o');
		map.put('u', 'u');
		for (int i = left; i <= right; i++) {
			char[] array = words[i].toCharArray();
			int start = 0;
			int end = words[i].length() -1;
			if (map.get(array[start]) != null && map.get(array[end]) != null) {
				ans++;
			}
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/?envType=daily-question&envId=2023-11-06
	 * @param nums
	 * @return
	 */
	public int findMaximumXOR(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				max = Math.max(max, nums[i] ^ nums[j]);
			}
		}
		return max;
	}

	/**
	 * https://leetcode.cn/problems/repeated-dna-sequences/?envType=daily-question&envId=2023-11-06
	 * @param s
	 * @return
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int length = 10;
		for (int i = 0; i <= s.length() - length; i++) {
			String sub = s.substring(i, i + length);
			map.put(sub, map.getOrDefault(sub, 0) + 1);
			if (map.get(sub) == 2) {
				result.add(sub);
			}
		}
		return result;
	}
}
