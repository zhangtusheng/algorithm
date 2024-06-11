package com.zts.week;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author zts
 * @date 2024/6/9 10:42
 * @Description:
 */
public class Week401 {

	public static void main(String[] args) {
		Week401 week401 = new Week401();
//		System.out.println(week401.numberOfChild(5, 2));
//		System.out.println(week401.numberOfChild(3, 5));
//		System.out.println(week401.valueAfterKSeconds(4, 5));
		System.out.println(week401.maxTotalReward(new int[]{1, 6, 4, 3, 2}));
	}


	/**
	 * https://leetcode.cn/contest/weekly-contest-401/problems/maximum-total-reward-using-operations-i/
	 * @param rewardValues
	 * @return: 强行贪心算法。
	 */
	public int maxTotalReward(int[] rewardValues) {
		int n = rewardValues.length;
		Arrays.sort(rewardValues);
		BigInteger f = BigInteger.ONE;
		for (int rewardValue : rewardValues) {
			BigInteger mask = BigInteger.ONE.shiftLeft(rewardValue).subtract(BigInteger.ONE);
			f = f.or(f.and(mask)).shiftLeft(rewardValue);
		}
		return f.bitLength() - 1;
	}


	/**
	 * https://leetcode.cn/contest/weekly-contest-401/problems/find-the-n-th-value-after-k-seconds/
	 * @param n
	 * @param k
	 * @return
	 */
	public int valueAfterKSeconds(int n, int k) {
		// 强行模拟：
		int mod = 1_000_000_007;
		int[] arr = new int[n];
		// 初始化0秒的情况。
		for (int i = 0; i < n; i++) {
			arr[i] = 1;
		}
		// 模拟k秒的情况
		for (int i = 0; i < k; i++) {
			int[] temp = new int[n];
			for (int j = 0; j < n; j++) {
				// 0号位置的情况
				if (j == 0) {
					temp[j] = arr[j];
				} else {
					temp[j] = (arr[j] + temp[j - 1]) % mod;
				}
			}
			arr = temp;
		}
		return arr[n - 1];
	}

	/**
	 * https://leetcode.cn/contest/weekly-contest-401/problems/find-the-child-who-has-the-ball-after-k-seconds/description/
	 */
	public int numberOfChild(int n, int k) {
		// 强行模拟
		int i = 1;
		int current = 0;
		boolean isRight = true;
		while (i <= k) {
			i++;
			if (current == 0) {
				isRight = true;
			} else if (current == n - 1) {
				isRight = false;
			}
			current += isRight ? 1 : -1;

		}
		return current;
	}
}
