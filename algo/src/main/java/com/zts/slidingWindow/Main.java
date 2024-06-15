package com.zts.slidingWindow;

import java.util.HashMap;
import java.util.Map;

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
		System.out.println(main.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
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
