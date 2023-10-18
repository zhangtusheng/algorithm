package com.zts.greedy;

import java.util.Arrays;

/**
 * @author zts
 * @date 2023/10/18 10:05
 * @Description: 贪心算法
 */
public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		//System.out.println(main.crackPassword(new int[] {5,54,52,67,68,5,52,17,93,53}));
		System.out.println(main.cuttingBamboo(127));
	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/lhp2v5/
	 * @param bamboo_len： 常规来说先3后2.
	 * @return
	 */
	public int cuttingBamboo(int bamboo_len) {
		long mod = 1000000007;
		if (bamboo_len <= 3) {
			return bamboo_len - 1;
		}
		long sum = 1;
		while (bamboo_len > 4) {
			bamboo_len = bamboo_len - 3;
			sum = (sum * 3) % mod;
		}
		return (int) ((sum * bamboo_len) % mod);
	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/lhrww7/
	 * @param password: "175252535455676893"
	 * @return
	 */
	public String crackPassword(int[] password) {
		String[] s = new String[password.length];
		for (int i = 0; i < password.length; i++) {
			s[i] = String.valueOf(password[i]);
		}
		Arrays.sort(s, (a, b) -> {
			String s1 = a + b;
			String s2 = b + a;
			return s1.compareTo(s2);
		});
		String result = "";
		for(int i = 0;i<s.length;i++) {
			result = result + s[i];
		}
		return result;
	}

	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/lho7d1/
	 * @param places
	 * @return
	 */
	public boolean checkDynasty(int[] places) {
		Arrays.sort(places);
		int zero = 0;
		int i = 0;
		for (;i < places.length; i++) {
			if (places[i] == 0) {
				zero++;
			} else {
				break;
			}
		}
		int sum = 0;
		for(int j = i+1;j<places.length;j++) {
			if (places[j] == places[j-1]) {
				return false;
			}
			sum += places[j] - places[j-1] - 1;
		}
		return zero >= sum;

	}
}
