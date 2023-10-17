package com.zts.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author zts
 * @date 2023/10/11 09:58
 * @Description
 */
public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		//System.out.println(main.wordBreak("leetcode", List.of("cats", "dog", "sand", "and", "cat")));
		//System.out.println(main.pathEncryption("a.aef.qerf.bb"));
//		System.out.println(main.myAtoi("4193 with words"));
//		System.out.println(main.myAtoi("2147483647"));
//		System.out.println(main.myAtoi("-42"));
		System.out.println(main.validNumber("abc"));
		System.out.println(main.validNumber("."));
		System.out.println(main.validNumber("e9"));
	}

	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7f3mmh/
	 * @param s
	 * @return
	 */
	public boolean validNumber(String s) {
		Map[] states = {
				new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
				new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1.
				new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
				new HashMap<>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
				new HashMap<>() {{ put('d', 3); }},                                        // 4.
				new HashMap<>() {{ put('s', 6); put('d', 7); }},                           // 5.
				new HashMap<>() {{ put('d', 7); }},                                        // 6.
				new HashMap<>() {{ put('d', 7); put(' ', 8); }},                           // 7.
				new HashMap<>() {{ put(' ', 8); }}                                         // 8.
		};
		int p = 0;
		char t;
		for(char c : s.toCharArray()) {
			if(c >= '0' && c <= '9') t = 'd';
			else if(c == '+' || c == '-') t = 's';
			else if(c == 'e' || c == 'E') t = 'e';
			else if(c == '.' || c == ' ') t = c;
			else t = '?';
			if(!states[p].containsKey(t)) return false;
			p = (int)states[p].get(t);
		}
		return p == 2 || p == 3 || p == 7 || p == 8;
	}



	/**
	 * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7f8nad/
	 * @param str
	 * @return
	 */
	public int myAtoi(String str) {
		int result = 0;
		str = str.trim();
		boolean flag = false;
		if (str.length() == 0 ) {
			return 0;
		}
		if (str.charAt(0) == '-') {
			flag = true;
		}
		int i = flag ? 1: 0;
		if (str.charAt(0) == '+') {
			i = 1;
		}
		int value = flag ? -1: 1;
		for(; i < str.length();i++) {
			char c = str.charAt(i);
			if ('0'<= c && c<= '9') {
				long result1 = 10L * result  + ((c - '0') * value);
				if (flag && result1 <= Long.parseLong(String.valueOf(Integer.MIN_VALUE))) {
					return Integer.MIN_VALUE;
				} else if (result1 >= Long.parseLong(String.valueOf(Integer.MAX_VALUE))){
					return Integer.MAX_VALUE;
				} else {
					result = (int) result1;

				}
			} else {
				break;
			}
		}
		return result;
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
