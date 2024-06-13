package com.zts.slidingWindow;

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
		System.out.println(main.minWindow("a", "a"));
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
