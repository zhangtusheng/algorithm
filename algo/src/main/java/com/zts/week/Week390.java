package com.zts.week;

/**
 * @author zts
 * @date 2024/4/20 19:38
 * @Description:https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/
 */
public class Week390 {

	public static void main(String[] args) {
		Week390 week390 = new Week390();

//		week390.maximumLengthSubstring(11);
	}


	/**
	 * https://leetcode.cn/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/
	 * @param k
	 * @return
	 */
	public int minOperations(int k) {
		// 给你一个正整数 k 。最初，你有一个数组 nums = [1] 。
		//你可以对数组执行以下 任意 操作 任意 次数（可能为零）：
		//选择数组中的任何一个元素，然后将它的值 增加 1 。
		//复制数组中的任何一个元素，然后将它附加到数组的末尾。
		//返回使得最终数组元素之 和 大于或等于 k 所需的 最少 操作次数
		//滑动窗口
		int[] arr = new int[k];
		int left = 0;
		int right = 0;
		int sum = 0;
		int ans = Integer.MAX_VALUE;
		while (right < k) {
			arr[right] = right + 1;
			sum += arr[right];
			right++;
		}
		while (right < k) {
			while (sum < k) {
				sum += arr[right];
				right++;
			}
			while (sum >= k) {
				ans = Math.min(ans, right - left);
				sum -= arr[left];
				left++;
			}
		}
		return ans;

	}



	/**
	 * https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/
	 * @param s
	 * @return
	 */
	public int maximumLengthSubstring(String s) {
		//给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该
		//子字符串
		//的 最大 长度。 如果 s 中不存在这样的子字符串，
		//则返回 0 。
		//滑动窗口
		int[] count = new int[26];
		int left = 0;
		int right = 0;
		int ans = 0;
		int length = s.length();
		while (right < length) {
			count[s.charAt(right) - 'a']++;
			while (count[s.charAt(right) - 'a'] > 2) {
				count[s.charAt(left) - 'a']--;
				left++;
			}
			ans = Math.max(ans, right - left + 1);
			right++;
		}
		return ans;
	}
}