package com.zts.everyday;

import java.util.Arrays;

/**
 * @author zts
 * @date 2024/1/10 14:42
 * @Description
 */
public class Main202401 {

	public static void main(String[] args) {
		Main202401 main202401 = new Main202401();
//		System.out.println(main202401.minLength("ACBBD"));
//		NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
//		//[0, 2], [2, 5], [0, 5]
//		System.out.println(numArray.sumRange(0, 2));
//		System.out.println(numArray.sumRange(2, 5));
//		System.out.println(numArray.sumRange(0, 5));
		System.out.println(main202401.minimumRemoval(new int[] {2, 10, 3, 2}));

	}


	/**
	 * https://leetcode.cn/problems/removing-minimum-number-of-magic-beans/?envType=daily-question&envId=2024-01-18
	 * @param beans
	 * @return
	 */
	public long minimumRemoval(int[] beans) {
		Arrays.sort(beans);
		long sum = 0, mx = 0;
		int n = beans.length;
		for (int i = 0; i < n; i++) {
			sum += beans[i];
			// 如果剩下的矩形面积越大，表示拿走的豆子比较少。
			mx = Math.max(mx, (long) beans[i] * (n - i));
		}
		return sum - mx;
	}


	/**
	 * https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/description/?envType=daily-question&envId=2024-01-10
	 * @param s
	 * @return
	 */
	public int minLength(String s) {
		// 1. 先替换AB，或者CD，
		// 剩下的继续观察是否能进行替换，如果可以替换的，继续进行替换。
		boolean flag = true;
		while (flag) {
			boolean k = false;
			if (s.contains("AB")) {
				s = s.replace("AB", "");
				k = true;
			}
			if (s.contains("CD")) {
				s = s.replace("CD", "");
				k = true;
			}
			flag = k;
		}
		return s.length();

	}

}
