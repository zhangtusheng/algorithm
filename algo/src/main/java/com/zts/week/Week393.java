package com.zts.week;

/**
 * @author zts
 * @date 2024/4/15 19:43
 * @Description：https://leetcode.cn/contest/weekly-contest-393/
 */
public class Week393 {

	public static void main(String[] args) {
		Week393 week393 = new Week393();
		System.out.println(week393.findLatestTime("1?:?0"));
		System.out.println(week393.findLatestTime("1?:?4"));
		System.out.println(week393.findLatestTime("0?:5?"));
	}


	/**
	 * https://leetcode.cn/problems/latest-time-you-can-obtain-after-replacing-characters/
	 * @param s
	 * @return
	 */
	public String findLatestTime(String s) {
		String[] split = s.split(":");
		String result = "";
		if (split[0].contains("?")) {
			if (split[0].charAt(0) == '?' ) {
				result = result +"1";
			} else {
				result = result + split[0].charAt(0);
			}
			if (split[0].charAt(1) == '?') {
				if (split[0].charAt(0) == '0') {
					result = result + "9";
				} else {
					result = result + "1";
				}
			} else {
				result = result + split[0].charAt(1);
			}
		} else {
			result = result + split[0];
		}
		result = result + ":";
		if (split[1].contains("?")) {
			if (split[1].charAt(0) == '?' ) {
				result = result + "5";
			} else {
				result = result + split[1].charAt(0);
			}
			if (split[1].charAt(1) == '?') {
				result = result + "9";
			} else {
				result = result + split[1].charAt(1);
			}
		} else {
			result = result + split[1];
		}
		return result;
	}

}

