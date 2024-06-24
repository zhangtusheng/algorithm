package com.zts.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * @author zts
 * @date 2024/6/24 18:04
 * @Description
 */
public class Top100 {

	public static void main(String[] args) {
		Top100 top100 = new Top100();
		System.out.println(JSON.toJSONString(top100.partitionLabels("ababcbacadefegdehijhklij")));
	}

	/**
	** https://leetcode.cn/problems/partition-labels/?envType=study-plan-v2&envId=top-100-liked
	 */
	public List<Integer> partitionLabels(String s) {
		// 用来记录对应的字符的最后位置。
		Map<Character, Integer> map = new HashMap<>();
		int[] windows = new int[26];
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		int left = 0, right = 0;
		int n = s.length();
		char[] charArray = s.toCharArray();
		List<Integer> result = new ArrayList<>();
		while (right < n) {
			// 判断left - right直接是否合法的。
			windows[charArray[right] - 'a']++;
			boolean isCorrect = true;
			for (int i = 0; i < 26; i++) {
				if (windows[i] != 0) {
					char key = (char) (i + 'a');
					Integer i1 = map.get(key);
					if (i1 > right) {
						isCorrect = false;
						break;
					}
				}
			}
			// 如果是合法的，那么就进行left的迁移。
			if (isCorrect) {
				Arrays.fill(windows, 0);
				// 填充区间；
				result.add(right - left + 1);
				left = right + 1;
			}
			right++;
		}
		return result;

	}
}
