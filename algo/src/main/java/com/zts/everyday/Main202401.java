package com.zts.everyday;

/**
 * @author zts
 * @date 2024/1/10 14:42
 * @Description
 */
public class Main202401 {

	public static void main(String[] args) {
		Main202401 main202401 = new Main202401();
		System.out.println(main202401.minLength("ACBBD"));
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
