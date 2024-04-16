package com.zts.week;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zts
 * @date 2024/4/15 19:43
 * @Description：https://leetcode.cn/contest/weekly-contest-393/
 */
public class Week393 {

	public static void main(String[] args) {
		Week393 week393 = new Week393();
//		System.out.println(week393.findLatestTime("1?:?0"));
//		System.out.println(week393.findLatestTime("1?:?4"));
//		System.out.println(week393.findLatestTime("0?:5?"));
//		System.out.println(week393.maximumPrimeDifference(new int[]{4, 2, 9, 5, 3}));
//		System.out.println(week393.maximumPrimeDifference(new int[]{4, 8, 2, 8}));
//		System.out.println(week393.maximumPrimeDifference(new int[]{2, 2}));

		System.out.println(week393.findKthSmallest(new int[]{2, 3, 5}, 5));
		System.out.println(week393.findKthSmallest(new int[]{3, 6, 9}, 3));
		System.out.println(week393.findKthSmallest(new int[]{5, 2}, 7));
	}


	/**
	 *https://leetcode.cn/problems/kth-smallest-amount-with-single-denomination-combination/
	 * @param coins
	 * @param k
	 * @return
	 */
	public long findKthSmallest(int[] coins, int k) {
		Map<Long, Long> map = new HashMap<>();
		Queue<NodeT> queue = new PriorityQueue<>((a, b) -> {
			return Math.toIntExact(a.current - b.current);
		});
		for (int i = 0; i < coins.length; i++) {
			queue.offer(new NodeT(coins[i], coins[i]));
		}
		int i = 0;
		long currentValue = 0;
		while (i < k) {
			NodeT poll = queue.poll();
			if (map.containsKey(poll.current)) {
				continue;
			}
			i++;
			currentValue = poll.current;
			NodeT nodeT = new NodeT(poll.current + poll.indexValue, poll.indexValue);
			map.put(currentValue, currentValue);
			queue.offer(nodeT);
		}
		return currentValue;
	}

	public static class NodeT {
		public long current;

		public long indexValue;

		public NodeT() {
		}

		public NodeT(long current, long indexValue) {
			this.current = current;
			this.indexValue = indexValue;
		}
	}


	/**
	 * https://leetcode.cn/problems/maximum-prime-difference/
	 * @param nums
	 * @return
	 */
	public int maximumPrimeDifference(int[] nums) {
		boolean[] isPrime = new boolean[nums.length];
		Integer minIndex = Integer.MAX_VALUE;
		Integer maxIndex = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			isPrime[i] = isPrime(nums[i]);
			if (isPrime[i]) {
				maxIndex = Math.max(maxIndex, i);
				minIndex = Math.min(minIndex, i);
			}
		}
		return maxIndex - minIndex;
	}

	private boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}


	/**
	 * https://leetcode.cn/problems/latest-time-you-can-obtain-after-replacing-characters/
	 * @param s
	 * @return
	 */
	public String findLatestTime(String s) {
		String result = "";
		String[] split = s.split(":");
		// 先处理后面的结果。
		if (split[1].charAt(0) == '?' && split[1].charAt(1) == '?') {
			result = "59";
		} else if (split[1].charAt(0) == '?') {
			result = "5" + split[1].charAt(1) + "";
		} else if (split[1].charAt(1) == '?') {
			result = split[1].charAt(0) + "9";
		} else {
			result = split[1];
		}

		// 处理前面两位。
		if (split[0].charAt(0) == '?' && split[0].charAt(1) == '?') {
			result = "11:" + result;
		} else if (split[0].charAt(0) == '?') {
			if (split[0].charAt(1) > '1') {
				result = "0" + split[0].charAt(1) + ":" + result;
			} else {
				result = "1" + split[0].charAt(1) + ":" + result;
			}
		} else if (split[0].charAt(1) == '?') {
			if (split[0].charAt(0) == '1') {
				result = split[0].charAt(0) + "1:" + result;
			} else {
				result = split[0].charAt(0) + "9:" + result;
			}
		} else {
			result = split[0] + ":" + result;
		}

		return result;
	}

}

