package com.zts.week;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zts
 * @date 2024/4/22 16:20
 * @Description:https://leetcode.cn/contest/weekly-contest-394/
 */
public class Week394 {

	public static void main(String[] args) {
Week394 week394 = new Week394();
		System.out.println(week394.numberOfSpecialChars("aaAbcBC"));
	}


	/**
	 * https://leetcode.cn/problems/count-the-number-of-special-characters-i/
	 * @param word
	 * @return
	 */
	public int numberOfSpecialChars(String word) {
		Map<String, String> map = new HashMap<>();
		Set<String> result = new HashSet<>();
		char[] charArray = word.toCharArray();
		for (char c : charArray) {
			if ('A' <= c && c <= 'Z') {
				map.put(String.valueOf(c), String.valueOf(c));
			}
		}
		for (char c : charArray) {
			if ('a' <= c && c <= 'z') {
				if (map.containsKey(String.valueOf((char) (c - 32)))) {
					result.add(String.valueOf(c));
				}
			}
		}
		return result.size();
	}

}
