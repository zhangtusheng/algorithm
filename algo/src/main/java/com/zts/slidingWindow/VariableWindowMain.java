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
//		System.out.println(main.longestNiceSubarray(new int[]{135745088,609245787,16,2048,2097152}));
//		System.out.println(main.minOperations(new int[]{3,2,20,1,1,3}, 10));
		System.out.println(main.minOperations(new int[] {5297, 4630, 701, 9863, 2861, 3825, 380, 5534, 5721, 1410, 4143, 1619,
			8122, 307, 9955, 7855, 3792, 5633, 4795, 8228, 2877, 874, 757, 7778, 7967, 4882, 9597, 1689, 1528, 4328, 3148, 506, 6477,
			3377, 6336, 7900, 6586, 155, 7750, 3021, 9345, 1639, 8983, 7919, 461, 1267, 1535, 3133, 387, 3592, 2092, 5570, 6787, 3247,
			7839, 6338, 1248, 6080, 7079, 4716, 7284, 8006, 7622, 7020, 6272, 4781, 3194, 2734, 55, 5882, 651, 4211, 9397, 2726, 6025,
			4046, 5782, 1090, 9789, 7335, 1987, 4487, 7947, 2184, 2249, 444, 8593, 9766, 6769, 4713, 5136, 2784, 6114, 7924, 58, 2204,
			5757, 3620, 292, 116, 4257, 2052, 4496, 8949, 8172, 7695, 1444, 7100, 6656, 7177, 1349, 7316, 6173, 3363, 7371, 6028, 7229,
			3668, 5406, 810, 1332, 4158, 7008, 6500, 1115, 8795, 4321, 8533, 3842, 5639, 2736, 2628, 8615, 1961, 3713, 1573, 395, 8582,
			4308, 4543, 7346, 3147, 9147, 3309, 5910, 2809, 4847, 9596, 9582, 2767, 5531, 7120, 5330, 8681, 1620, 6028, 6259, 4890, 7866,
			5187, 8132, 4238, 1890, 1776, 4913, 5303, 7976, 9562, 4878, 1130, 7523, 2995, 3798, 4033, 5202, 5688, 5078, 5576, 8131, 5040,
			3886, 2046, 4863, 3740, 6204, 5579, 3844, 3840, 4912, 1540, 8886, 6988, 3459, 1174, 5103, 1332, 103, 685, 7350, 1580, 6855,
			8102, 3033, 406, 4169, 9001, 484, 940, 5074, 1083, 8392, 971, 2178, 9617, 4840, 2680, 2338, 6927, 2710, 766, 9182, 2305, 4106,
			1042, 6120, 1035, 9759, 2154, 227, 3966, 4079, 1329, 4100, 4752, 5529, 1830, 589, 3932, 9700, 7331, 152, 6110, 6888, 4389, 8814,
			4221, 2777, 7559, 1393, 1069, 8690, 6360, 3534, 2978, 971, 6984, 5797, 778, 3261, 2328, 9258, 5508, 3896, 62, 9599, 3361, 1394,
			7634, 2616, 3752, 492, 890, 3951, 3957, 9903, 303, 5511, 8158, 6443, 1097, 4581, 2007, 2691, 9852, 1376, 8718, 7361, 1763, 9273,
			1904, 4709, 321, 2513, 7193, 7524, 1606, 4497, 7987, 2557, 6676, 5254, 8380, 8815, 3032, 4659, 7876, 8553, 4554, 584, 3946, 8902,
			4052, 5665, 910, 6767, 8791, 769, 6601, 4082, 6349, 2193, 6529, 7929, 6790, 8797, 2122, 5641, 5481, 8955, 536, 8851, 7945, 2089, 8317,
			3356, 151, 9295, 6619, 8422, 5584, 1286, 342, 8060, 9912, 7803, 6322, 9289, 4024, 8287, 6400, 3152, 8858, 1040, 8671, 4850, 2369, 3471,
			6244, 9655, 1689, 6277, 1889, 6372, 2356, 3191, 1679, 1547, 3771, 7100, 2884, 7052, 8577, 692, 9321, 2755, 4748, 8861, 6255, 3324, 3446,
			7111, 3909, 9860, 7079, 4585, 3459, 9142, 9475, 4612, 7990, 2226, 5714, 5882, 2566, 8240, 4078, 7992, 7313, 9980, 8246, 1418, 7782, 691,
			1507, 1825, 4466, 2757, 5950, 163, 8669, 82, 5877, 5889, 9539, 3617, 6002, 8737, 3991, 4113, 4351, 3346, 763, 5413, 9538, 2879, 4870, 8758,
			7509, 7251, 3028, 9625, 3825, 7523, 8398, 6455, 5988, 4752, 458, 9425, 1278, 9866, 4923, 6949, 2878, 6039, 6053, 510, 7375, 9296, 837,
			2649, 2636, 8712, 8597, 6554, 6526, 5546, 4952, 2013, 9963, 2442, 6660, 9431, 779, 5844, 7862, 5857, 5382, 7234, 4068, 8149, 5367, 1837,
			9707, 9535, 4779, 1949, 2123, 5074, 5269, 149, 1543, 489, 9301, 5954, 9395, 4615, 9624, 2501, 7762, 853, 9987, 2752, 4254, 993, 8755,
			3531, 172, 1070, 1582, 7982, 4989, 7704, 9964, 6708, 5096, 8054, 2106, 5848, 7060, 5066, 9294, 7645, 2284, 937, 6483, 6288, 826, 6288,
			7599, 3966, 2313, 8883, 260, 3971, 9303, 4867, 5625, 9206, 7937, 4844, 664, 1612, 3951, 4099, 8718, 4390, 1898, 7026, 8658, 1711, 4765,
			8701, 1313, 2826, 1035, 1422, 2728, 8241, 3183, 1019, 272, 7179, 3630, 423, 8427, 8723, 6488, 6960, 243, 8016, 4956, 9412, 8791, 7545,
			926, 4828, 1670, 3836, 1460, 5933, 5588, 6465, 1235, 6293, 7652, 3428, 7881, 6213, 4245, 8187, 4502, 3823, 4374, 7518, 8998, 505, 1915,
			4413, 1584, 9618, 2293, 5954, 5143, 5953, 1881, 6658, 5326, 1545, 2549, 2576, 8598, 6926, 5087, 7494, 812, 8371, 4226, 7372, 808, 8408,
			8608, 8710, 4907, 2451, 3193, 7943, 5566, 9226, 5046, 25, 8431, 4864, 6381, 490, 9193, 9821, 6703, 6059, 7864, 9931, 6568, 2000, 590,
			1577, 7748, 1638, 14, 9358, 776, 9500, 1367, 6951, 2849, 8163, 9332, 9570, 6022, 8480
		}, 382801));

	}


	/**
	 * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
	 * @param nums
	 * @param x
	 * @return
	 */
	public int minOperations(int[] nums, int x) {
		int ans = -1 ;
		int left = 0, right = 0;
		int sum = 0;
		int target = -x;
		for (int num : nums) target += num;
		if (target < 0) return -1;
		while (right < nums.length) {
			sum += nums[right];
			while (sum > target) {
				sum -= nums[left];
				left++;
			}
			if (sum == target) {
				ans = Math.max(ans, right - left + 1);
			}
			right++;
		}
		return ans < 0 ? -1 : nums.length - ans;
	}

	/**
	 * https://leetcode.cn/problems/longest-nice-subarray/description/
	 * @param nums
	 * @return
	 */
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
				if (map.get(nums[left]) == 0) {
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
