package com.zts.bit;

import com.alibaba.fastjson.JSON;

/**
 * @author zts
 * @date 2024/6/25 16:33
 * @Description
 */
public class BitMain {

	public static void main(String[] args) {
		BitMain bitMain = new BitMain();
		System.out.println(JSON.toJSONString(bitMain.evenOddBit(50)));
	}

	/**
	 * https://leetcode.cn/problems/power-of-two/
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo(int n) {
		if (n == 1 || n == 0) {
			return n == 1;
		}
		while (n > 1) {
			if (n % 2 != 0) {
				return false;
			}
			n = n / 2;
		}
		return true;
	}

	/**
	 * https://leetcode.cn/problems/number-of-even-and-odd-bits/
	 * @param n
	 * @return
	 */
	public int[] evenOddBit(int n) {
		String binaryString = Integer.toBinaryString(n);
		int even = 0;
		int odd = 0;
		int length = binaryString.length();
		// 从后往前遍历
		for (int i = length -1; i >= 0 ; i--) {
			if (binaryString.charAt(i) != '1') {
				continue;
			}
			int k = length - i - 1;
			if (k % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		return new int[] {even, odd};
	}
}
