package com.zts.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.alibaba.fastjson.JSON;

/**
 * @author zts
 * @date 2024/6/12 19:45
 * @Description：滑动窗口题目
 */
public class Main {

	public static void main(String[] args) {
		Main main = new Main();
//		System.out.println(main.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
//		System.out.println(main.lengthOfLongestSubstringTwoDistinct("eceba"));
//		System.out.println(main.minWindow("ADOBECODEBANC", "ABC"));
//		System.out.println(main.minWindow("a", "a"));
//		System.out.println(main.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
//		System.out.println(main.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
//		System.out.println(main.longestSubstring("bchhbbdefghiaaacb", 3));
//		System.out.println(main.longestSubstring("a", 1));
//		System.out.println(main.characterReplacement("ABAB", 2));
//		System.out.println(main.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));
		System.out.println(JSON.toJSONString(main.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
	}

	/**
	 * https://leetcode.cn/problems/sliding-window-median/
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public double[] medianSlidingWindow(int[] nums, int k) {
		List<Double> result = new ArrayList<>();
		int left = 0, right = 0;
		PriorityQueue<Integer> priorityQueue =  new PriorityQueue<>();
		PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(((o1, o2) -> o2-o1));
		for(; right < nums.length ; right++) {
			maxPriorityQueue.offer(nums[right]);
			while (priorityQueue.size() + maxPriorityQueue.size() > k) {
				if (!priorityQueue.remove(nums[left])) {
					maxPriorityQueue.remove(nums[left]);
				}
				if (priorityQueue.size() > maxPriorityQueue.size()) {
					maxPriorityQueue.offer(priorityQueue.poll());
				} else {
					priorityQueue.offer(maxPriorityQueue.poll());
				}
				left++;
			}
			if (priorityQueue.size() + maxPriorityQueue.size() == k) {
				// 偶数
				if (k % 2 == 0){
					int length = k;
					if (maxPriorityQueue.peek() == priorityQueue.peek()) {
						result.add(Double.valueOf(priorityQueue.peek()));
					} else {
						int i = maxPriorityQueue.peek() + priorityQueue.peek();
						result.add(i * 1.0 / 2);
					}
				} else {
					if (maxPriorityQueue.size() > priorityQueue.size()) {
						result.add(Double.valueOf(maxPriorityQueue.peek()));
					}else {
						result.add(Double.valueOf(priorityQueue.peek()));
					}
				}
			}
		}
		return result.stream().mapToDouble(Double::doubleValue).toArray();
	}


	/**
	 * https://leetcode.cn/problems/max-consecutive-ones-ii/
	 * @param nums
	 * @return
	 */
	public int findMaxConsecutiveOnes(int[] nums) {
		// 提前处理一下，当前的1的连续的的最长是多少。如果是符合要求的话，就进行处理。
		int ans = 0;
		int[] windows = new int[2];
		int left = 0, right = 0;
		int n = nums.length;
		for(; right < n; right++) {
			windows[nums[right]]++;
			// 计算区间是否合理。left - right区间。
			while (windows[0] > 1) {
				windows[nums[left]]--;
				left++;
			}
			ans = Math.max(ans, right - left + 1);
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/longest-repeating-character-replacement/
	 * @param s
	 * @param k
	 * @return
	 */
	public int characterReplacement(String s, int k) {
		int[] windows = new int[128];
		int ans = 0;
		int left = 0, right = 0;
		int n = s.length();
		char[] charArray = s.toCharArray();
		while (right < n) {
			windows[charArray[right]]++;
			boolean checkCorrect = false;
			if (left < n) {
				// 检查是否符合要求
				while (!checkCorrect) {
					// 不同的个数，取最大值。然后进行计算。
					int maxChar = 0;
					int diff = 0;
					for (int i = 0; i < 128; i++) {
						maxChar = Math.max(maxChar, windows[i]);
						if (windows[i] > 0) {
							diff++;
						}
					}
					// 两种情况，一种是diff==1，另外一种是maxChar在当前操作范围内的。(right - left + 1 ) - maxChar
					if (diff == 1 || (diff > 1 && (right - left + 1) - maxChar <= k)) {
						checkCorrect = true;
						ans = Math.max(ans, right - left + 1);
					} else {
						windows[charArray[left]] --;
						left++;
					}
				}
			}
			right++;
		}
		return ans;
	}



	/**
	 * https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
	 * @param s
	 * @param k
	 * @return
	 */
	public int longestSubstring(String s, int k) {
		int n = s.length();
		char[] charArray = s.toCharArray();
		int[] windows = new int[128];
		int left = 0, right = 0;
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (right < n) {
			// 如果当前是合法的，那么往前能衍生多少的长度，或者说区间是多大。
			windows[charArray[right]]++;
			map.put(charArray[right], right);
			if (windows[charArray[right]] >= k) {
				int[] ints = Arrays.copyOfRange(windows, 0, 128);
				// 从左边开始，当左边已经是符合要求了，这个时候是可以正常的进行处理的。
				for (int i = 0; i <= right; i++) {
					if (check(ints, k)) {
						ans = Math.max(ans, right - i + 1);
						break;
					}
					ints[charArray[i]] --;
				}
			}
			right++;
		}
		return ans;
	}

	private boolean check(int[] windows, int k) {
		for (int i = 0; i < 128; i++) {
			if (windows[i] != 0 && windows[i] < k) {
				return false;
			}
		}
		return true;
	}

	/**
	 * https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/
	 * @param s
	 * @param k
	 * @return
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		// 滑动窗口统计出现的数量。
		int[] window = new int[128];
		int ans = 0;
		int left = 0, right = 0;
		int length = 0;
		while (right < s.length()) {
			char c = s.charAt(right);
			window[c]++;
			if (window[c] == 1) {
				ans++;
			}
			while (ans > k) {
				// 窗口左边的字母，进行减法。
				char d = s.charAt(left);
				window[d]--;
				if (window[d] == 0) {
					ans--;
				}
				left++;
			}
			length = Math.max(length, right - left + 1);
			right++;
		}
		return length;

	}


	/**
	 * https://leetcode.cn/problems/contains-duplicate-iii/
	 * @param nums
	 * @param k
	 * @param t: 思路是将元素划分成不同的捅。例如第一个捅是t+valueDiff，另一个是t-valueDiff。
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		int n = nums.length;
		Map<Long, Long> map = new HashMap<>();
		long w = (long) t + 1;
		for (int i = 0; i < n; i++) {
			long id = getId(nums[i], w);
			if (map.containsKey(id)) {
				return true;
			}
			if (map.containsKey(id - 1) && Math.abs(map.get(id - 1) - nums[i]) < w) {
				return true;
			}
			if (map.containsKey(id + 1) && Math.abs(map.get(id + 1) - nums[i]) < w) {
				return true;
			}
			map.put(id, (long) nums[i]);
			if (i >= k) {
				map.remove(getId(nums[i - k], w));
			}
		}
		return false;
	}

	// 很多小伙伴对getID有点迷惑,就是为什么取负数,如w=10, 因为非负数是09，1019...
	// 这种一组，而负数是-1~-10, 为什么要先加一，就是让-1~-10变成0~-9，这样就和非负数一样了
	// -11~-20...这些是一组，如果-1~-10直接除以10，会被分到两组中，而不是-1这一组，
	// 所以先+1变成-0--9,与正数一致，再除以10，最后减1，正好是-1这一组，其它组也是同理
	private long getId(long x, long w) {
		return x < 0 ? (x + 1) / w - 1 : x / w;
	}


	/**
	 * https://leetcode.cn/problems/contains-duplicate-ii/
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		boolean result = false;
		int right = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (right < nums.length) {
			int num = nums[right];
			if (map.containsKey(num)) {
				if (right - map.get(num) <= k) {
					result = true;
					break;
				}
			}
			map.put(num, right);
			right++;
		}
		return result;
	}



	/**
	 * https://leetcode.cn/problems/minimum-window-substring/
	 * @param s
	 * @param t
	 * @return
	 */
	public String minWindow(String s, String t) {
		// 记录窗口内字符出现的次数。
		int[] window = new int[128];
		int ans = 0;
		int left = 0, right = 0;
		int minLen = Integer.MAX_VALUE;
		String result = "";
		int[] tCount = new int[128];
		for (int i = 0; i < t.length(); i++) {
			tCount[t.charAt(i)]++;
		}
		while (right < s.length()) {
			char c = s.charAt(right);
			window[c]++;
			while (check(window, tCount)) {
				if (right - left + 1 < minLen) {
					result = s.substring(left, right + 1);
					minLen = right - left + 1;
					ans = right - left + 1;
				}
				char d = s.charAt(left);
				window[d]--;
				left++;
			}
			right++;
		}
		return result;
	}

	private boolean check(int[] window, int[] tCount) {
		for (int i = 0; i < 128; i++) {
			if (window[i] < tCount[i]) {
				return false;
			}
		}
		return true;
	}


	/**
	 * https://leetcode.cn/problems/longest-substring-with-at-most-two-distinct-characters/
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		// 窗口内字符出现的种类。
		int windowCount = 0;
		int ans = 0;
		int left = 0, right = 0;
		int[] window = new int[128];
		while (right < s.length()) {
			char c = s.charAt(right);
			if (window[c] == 0) {
				windowCount++;
			}
			window[c]++;
			while (windowCount > 2) {
				char d = s.charAt(left);
				window[d]--;
				if (window[d] == 0) {
					windowCount--;
				}
				left++;
			}
			ans = Math.max(ans, right - left + 1);
			right++;
		}
		return ans;
	}

	/**
	 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/xia-biao-zong-suan-cuo-qing-kan-zhe-by-e-iaks/
	 */
	public int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0;
		int[] window = new int[128];
		int ans = 0;
		int length = s.length();
		while (right < length) {
			char c = s.charAt(right);
			window[c]++;
			while (window[c] > 1) {
				char d = s.charAt(left);
				window[d]--;
				left++;
			}
			ans = Math.max(ans, right - left + 1);
			right++;
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/subarray-product-less-than-k/
	 * @param nums
	 * @param k
	 * @return
	 */
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k == 0) {
			return 0;
		}
		int ans = 0;
		int left = 0, right = 0;
		int product = 1;
		while (right < nums.length) {
			product *= nums[right];
			while (product >= k && left <= right) {
				product /= nums[left];
				left++;
			}
			ans += right - left + 1;
			right++;
		}
		return ans;
	}

	/**
	 * https://leetcode.cn/problems/minimum-size-subarray-sum/
	 * @param target
	 * @param nums
	 * @return
	 */
	public int minSubArrayLen(int target, int[] nums) {
		int ans = Integer.MAX_VALUE;
		int sum = 0;
		int left = 0, right = 0;
		while (right < nums.length) {
			sum += nums[right];
			while (sum >= target && left <= right) {
				ans = Math.min(ans, right - left + 1);
				sum -= nums[left];
				left++;
			}
			right++;
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}
}
