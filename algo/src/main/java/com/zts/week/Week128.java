package com.zts.week;

import java.util.Arrays;

/**
 * @author zts
 * @date 2024/4/17 19:43
 * @Description
 */
public class Week128 {

	public static void main(String[] args) {
		Week128 week128 = new Week128();
//		System.out.println(week128.scoreOfString("hello"));
//		System.out.println(week128.scoreOfString("zaz"));

		System.out.println(week128.minRectanglesToCoverPoints(new int[][]{{0, 0},{1,1},{2,2},{3,3},{4,4},{5,5},{6,6}}, 2));
		System.out.println(week128.minRectanglesToCoverPoints(new int[][]{{2, 3},{1,2}}, 0));
	}

	/**
	 * https://leetcode.cn/problems/score-of-a-string/
	 * @param s
	 * @return
	 */
	public int scoreOfString(String s) {
		int ans = 0 ;
		int length = s.length();
		char[] charArray = s.toCharArray();
		for (int i = 1; i < length; i++) {
			ans += Math.abs(charArray[i] - charArray[i - 1]);
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/minimum-rectangles-to-cover-points/
	 * @param points
	 * @param w
	 * @return
	 */
	public int minRectanglesToCoverPoints(int[][] points, int w) {
		// 直接进行模拟，按照points的节点直接进行排序。
		Arrays.sort(points, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});
		int ans = 0;
		int length = points.length;
		int start = points[0][0];
		int i = 0;
		while (i < length) {
			ans++;
			int end = start + w;
			while (i < length && points[i][0] <= end) {
				i++;
			}
			if (i < length) {
				start = points[i][0];
			}
		}
		return ans;
	}


}
