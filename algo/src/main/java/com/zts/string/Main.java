package com.zts.string;

import java.util.List;

/**
 * @author zts
 * @date 2023/10/11 09:58
 * @Description
 */
public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		//System.out.println(main.wordBreak("leetcode", List.of("cats", "dog", "sand", "and", "cat")));
		System.out.println(main.pathEncryption("a.aef.qerf.bb"));
	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7ftd2s/
	 * @param password
	 * @param target
	 * @return
	 */
	public String dynamicPassword(String password, int target) {
		if (target >= password.length()) {
			target = target % password.length();
		}
		return password.substring(target) + password.substring(0, target);

	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fulvr/
	 * @param message
	 * @return
	 */
	public String reverseMessage(String message) {
		String[] s = message.trim().split(" ");
		String result = s[s.length - 1];
		for (int i = s.length - 2; i >=0 ; i--) {
			if (s[i].length() == 0) {
				continue;
			}
			result = result + " " + s[i];
		}
		return result;
	}


	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fitwt/
	 * @param path
	 * @return
	 */
	public String pathEncryption(String path) {
		if (path == null || path.length() == 0) {
			return path;
		}
		return path.replace(".", " ");
	}


	public int longestRepeatingSubstring(String s) {
		int length =1;
		int[] visited = new int[256];
		if (s == null || s.length() == 0) {
			return 0;
		}
		int j = 0;
		char[] charArray = s.toCharArray();
		visited[charArray[0]]++;
		for(int i = 1;i<charArray.length;i++) {
			char c = charArray[i];
			if (visited[c] == 0) {
				visited[c] = 1;

			} else {
				j++;

			}
			length = Math.max(length, i - j + 1);
		}
		return length;
	}


	/**
	 * https://leetcode.cn/problems/word-break/
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] hs = new boolean[256];
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			hs[c] = true;
		}
		boolean result = true;
		for (String string : wordDict) {
			char[] charArray1 = string.toCharArray();
			for (char c : charArray1) {
				if (!hs[c]) {
					return false;
				}
			}
		}
		return result;
	}
}
