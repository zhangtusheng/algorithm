package com.zts.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.zts.model.ListNode;

/**
 * @author zts
 * @date 2024/5/8 15:15
 * @Description
 */
public class Main202405 {

	public static void main(String[] args) {
		Main202405 main202405 = new Main202405();
//		System.out.println(main202405.wateringPlants(new int[] {2, 2, 3, 3}, 5));
//		System.out.println(main202405.wateringPlants(new int[] {1,1,1,4,2,3}, 4));
//		System.out.println(main202405.minimumRefill(new int[] {2, 2, 3, 3}, 5, 5));
//		System.out.println(main202405.minimumRefill(new int[] {2, 2, 3, 3}, 3, 4));
//		System.out.println(main202405.minimumRefill(new int[] {5}, 10, 8));

//		System.out.println(JSON.toJSONString(main202405.findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}})));

//		System.out.println(JSON.toJSONString(main202405.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8)));
//		System.out.println(JSON.toJSONString(main202405.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5)));
//		System.out.println(JSON.toJSONString(main202405.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));

//		System.out.println(JSON.toJSONString(main202405.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})));

//		System.out.println(JSON.toJSONString(main202405.sortList(ListNode.createListNode(new int[]{-1,5,3,4,0}))));

//		System.out.println(JSON.toJSONString(main202405.insertionSortList(ListNode.createListNode(new int[]{-1,5,3,4,0}))));

//		System.out.println(JSON.toJSONString(main202405.findSubstring("barfoothefoobarman", new String[]{"foo","bar"})));
//		//  "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//		System.out.println(JSON.toJSONString(main202405.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"})));
//		// "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//		System.out.println(JSON.toJSONString(main202405.findSubstring("barfoothefoobarman", new String[]{"bar","foo"})));
//		//
//		System.out.println(JSON.toJSONString(main202405.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"})));

//		System.out.println(main202405.simplifyPath("/a//b////c/d//././/.."));
//		System.out.println(main202405.simplifyPath("/home/"));

//		System.out.println(JSON.toJSONString(main202405.restoreIpAddresses("25525511135")));
//		System.out.println(JSON.toJSONString(main202405.restoreIpAddresses("101023")));

//		System.out.println(main202405.maximalRectangle(new char[][]{
//			{'1','0','1','0','0'},
//			{'1','0','1','1','1'},
//			{'1','1','1','1','1'},
//			{'1','0','0','1','0'}
//		}));
//
//		System.out.println(main202405.maximalRectangle(new char[][]{
//			{'1','1'},
//			{'1','1'}
//		}));
//
//		System.out.println(main202405.maximalRectangle(new char[][]{
//			{'0','0','1','0'},
//			{'0','0','1','0'},
//			{'0','0','1','0'},
//			{'0','0','1','1'},
//			{'0','1','1','1'},
//			{'0','1','1','1'},
//			{'1','1','1','1'}
//		}));
//
//		System.out.println(main202405.maximalRectangle(new char[][]
//			{{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'}}));

//		System.out.println(main202405.maximalRectangle(new char[][]{
//			{'1','1','1','1','1','1','0','1','1','1','1','1','1','1','1'},
//			{'1','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
//			{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
//			{'0','1','1','1','1','1','1','0','1','1','1','0','1','1','1'},
//			{'1','0','0','1','1','1','1','1','1','1','1','0','1','1','1'},
//			{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
//			{'1','1','1','0','1','1','1','1','1','1','1','0','1','1','1'},
//			{'1','1','1','1','0','0','0','1','1','1','1','1','0','1','0'},
//			{'1','0','1','1','0','0','0','1','1','1','1','0','1','0','1'},
//			{'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1'},
//			{'1','0','1','1','1','1','1','1','1','1','1','1','1','1','1'},
//			{'1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
//			{'1','1','1','0','0','0','1','0','1','1','1','1','1','1','1'},
//			{'1','1','1','1','1','1','0','1','1','1','1','1','1','1','1'},
//			{'1','1','1','1','1','1','1','0','1','1','1','1','1','0','1'}
//		}));



	}


	/**
	 * 有效数独：https://leetcode.cn/problems/valid-sudoku/
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		// 行
		for (int i = 0; i < 9; i++) {
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (set.contains(board[i][j])) {
					return false;
				}
				set.add(board[i][j]);
			}
		}
		// 列
		for (int i = 0; i < 9; i++) {
			Set<Character> set = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[j][i] == '.') {
					continue;
				}
				if (set.contains(board[j][i])) {
					return false;
				}
				set.add(board[j][i]);
			}
		}
		// 3*3
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				Set<Character> set = new HashSet<>();
				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 3; l++) {
						if (board[k][l] == '.') {
							continue;
						}
						if (set.contains(board[k][l])) {
							return false;
						}
						set.add(board[k][l]);
					}
				}
			}
		}
		return true;
	}


	/**
	 * https://leetcode.cn/problems/maximal-rectangle/description/
	 * @param matrix
	 * @return
	 **/
	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if (m == 0) {
			return 0;
		}
		int n = matrix[0].length;
		int[][] left = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
				}
			}
		}

		int ret = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') {
					continue;
				}
				int width = left[i][j];
				int area = width;
				for (int k = i - 1; k >= 0; k--) {
					width = Math.min(width, left[k][j]);
					area = Math.max(area, (i - k + 1) * width);
				}
				ret = Math.max(ret, area);
			}
		}
		return ret;
	}


	/**
	 * https://leetcode.cn/problems/restore-ip-addresses/
	 * @param s
	 * @return
	 */
	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		dfs(s, 0, 0, new ArrayList<>(), result);
		return result;
	}

	private void dfs(String s, int index, int count, List<String> path, List<String> result) {
		if (count == 4) {
			if (index == s.length()) {
				result.add(String.join(".", path));
			}
			return;
		}
		for (int i = 1; i<=3; i++) {
			if (index + i > s.length()) {
				break;
			}
			String sub = s.substring(index, index+ i);
			if (sub.startsWith("0") && sub.length() > 1) {
				continue;
			}
			int num = Integer.parseInt(sub);
			if (num >= 0 && num <= 255) {
				path.add(sub);
				dfs(s, index + i, count + 1, path, result);
				path.remove(path.size() - 1);
			}
		}
	}


	/**
	 * https://leetcode.cn/problems/simplify-path/
	 * @param path
	 * @return
	 */
	public String simplifyPath(String path) {
		String[] paths = path.split("/");
		List<String> list = new ArrayList<>();
		for (String p : paths) {
			if (p.equals("") || p.equals(".")) {
				continue;
			}
			if (p.equals("..")) {
				if (!list.isEmpty()) {
					list.remove(list.size() - 1);
				}
			} else {
				list.add(p);
			}
		}
		return "/" + String.join("/", list);
	}


	/**
	 * https://leetcode.cn/problems/set-matrix-zeroes/
	 * @param matrix
	 */
	public void setZeroes(int[][] matrix) {
		boolean[][] flag = new boolean[matrix.length][matrix[0].length];
		// 先标记一下。
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					flag[i][j] = true;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (flag[i][j]) {
					for (int k = 0; k < matrix.length; k++) {
						matrix[k][j] = 0;
					}
					for (int k = 0; k < matrix[0].length; k++) {
						matrix[i][k] = 0;
					}
				}
			}
		}

	}


	/**
	 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/description/
	 * @param s
	 * @param words
	 * @return
	 */
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		// 需要枚举的字符串的长度。
		int length = words[0].length() *  words.length;

		for (int i = 0; i <= s.length() - length; i++) {
			String sub = s.substring(i, i + length);
			if (check(sub, words)) {
				result.add(i);
			}
		}
		return result;
	}

	private boolean check(String sub, String[] words) {
		Map<String, Integer> map = new HashMap<>();
		int length = words[0].length();
		int i = 0;
		while (i < sub.length()) {
			String word = sub.substring(i, i + length);
			map.put(word, map.getOrDefault(word, 0) + 1);
			i += length;
		}
		for (String word : words) {
			if (map.get(word) == null || map.get(word) == 0) {
				return false;
			}
			map.put(word, map.get(word) - 1);
		}
		return true;
	}





	/**
	 * https://leetcode.cn/problems/read-n-characters-given-read4/
	 * @param buf
	 * @param n
	 * @return
	 */
	public int read(char[] buf, int n) {
		int i = 0;
		while (i < n) {
			char[] buffer = new char[4];
			int k = read4(buffer);
			for(int j = 0;j<k;j++){
				if (i >= n) break;
				buf[i] = buffer[j];
				i++;
			}
			if (k != 4) {
				break;
			}
		}
		return i;
	}

	private int read4(char[] buf) {
		return 4;
	}


	/**
	 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
	 * @param nums:最好利用二分法来进行处理，不然不符合题目要求。
	 * @return
	 */
	public int findMin(int[] nums) {
		int minAns = Integer.MAX_VALUE;
		for (int num : nums) {
			minAns = Math.min(minAns, num);
		}
		return minAns;
	}


	/**
	 * https://leetcode.cn/problems/insertion-sort-list/
	 * @param head：链表插入排序。
	 * @return
	 */
	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode newHead = new ListNode(-5000000);
		ListNode current = head;
		ListNode newCurrent = newHead;
		while (current != null) {
			ListNode next = current.next;
			newCurrent = newHead;
			while (newCurrent.next != null && newCurrent.next.val < current.val) {
				newCurrent = newCurrent.next;
			}
			ListNode newCurrentNext = newCurrent.next;
			newCurrent.next = current;
			current.next = newCurrentNext;
			current = next;
		}
		return newHead.next;

	}


	/**
	 * https://leetcode.cn/problems/sort-list/
	 * @param head
	 * @return
	 */
	public ListNode sortList(ListNode head) {
		List<ListNode> list = new ArrayList<>();
		ListNode current = head;
		list.add(current);
		while (current.next != null) {
			current = current.next;
			list.add(current);
		}
		list.sort((a, b) -> a.val - b.val);
		ListNode newHead = new ListNode(-1);
		current = newHead;
		for (int i = 0; i < list.size(); i++) {
			ListNode next = list.get(i);
			next.next = null;
			current.next = next;
			current = current.next;
		}
		return newHead.next;
	}


	/**
	 * https://leetcode.cn/problems/insert-interval/
	 * @param intervals
	 * @param newInterval
	 * @return
	 */
	public int[][] insert(int[][] intervals, int[] newInterval) {
		// 重新构造一个这样的数组，然后进行合并。
		int[][] newIntervals = new int[intervals.length + 1][2];
		for (int i = 0; i < intervals.length; i++) {
			newIntervals[i] = intervals[i];
		}
		newIntervals[intervals.length] = newInterval;
		return merge(newIntervals);
	}


	/**
	 * https://leetcode.cn/problems/merge-intervals/
	 * @param intervals：[[1,3],[2,6],[8,10],[15,18]]
	 * @return：[[1,6],[8,10],[15,18]]
	 */
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});
		List<int[]> result = new ArrayList<>();
		// 当前区间为多少。
		int[] start = new int[] {intervals[0][0], intervals[0][1]};
		result.add(start);
		for (int i = 1; i < intervals.length; i++) {
			int[] interval = intervals[i];
			if (interval[0] <= start[1]) {
				start[1] = Math.max(start[1], interval[1]);
			} else {
				start = new int[] {interval[0], interval[1]};
				result.add(start);
			}
		}
		// 转换成数组。
		return result.toArray(new int[result.size()][]);
	}


	/**
	 * ：https://leetcode.cn/problems/combination-sum-ii/
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(candidates, target, 0, path, result);
		return result;
	}

	private void dfs(int[] candidates, int target, int begin, List<Integer> path, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = begin; i < candidates.length; i++) {
			if (target - candidates[i] < 0) {
				continue;
			}
			if (i > begin && candidates[i] == candidates[i - 1]) {
				continue;
			}
			path.add(candidates[i]);
			dfs(candidates, target - candidates[i], i + 1, path, result);
			path.remove(path.size() - 1);
		}
	}


	/**
	 * https://leetcode.cn/problems/find-players-with-zero-or-one-losses/?envType=daily-question&envId=2024-05-22
	 * @param matches
	 * @return
	 */
	public List<List<Integer>> findWinners(int[][] matches) {
		// 记录赢的次数。
		Map<Integer, Integer> winerMap = new HashMap<>();
		// 记录输的次数.
		Map<Integer, Integer> loserMap = new HashMap<>();
		// 参赛选手。
		Set<Integer> set = new HashSet<>();
		for (int[] match : matches) {
			int winner = match[0];
			int loser = match[1];
			winerMap.put(winner, winerMap.getOrDefault(winner, 0) + 1);
			loserMap.put(loser, loserMap.getOrDefault(loser, 0) + 1);
			set.add(winner);
			set.add(loser);
		}
		List<Integer> allWiners = new ArrayList<>();
		List<Integer> onlyOnceLosers = new ArrayList<>();
		for (Integer player : set) {
			if (loserMap.get(player) == null) {
				allWiners.add(player);
			} else if (loserMap.get(player) == 1) {
				onlyOnceLosers.add(player);
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		result.add(allWiners.stream().sorted().collect(Collectors.toList()));
		result.add(onlyOnceLosers.stream().sorted().collect(Collectors.toList()));
		return result;
	}

	/**
	 * https://leetcode.cn/problems/watering-plants/?envType=daily-question&envId=2024-05-08
	 * @param plants
	 * @param capacity
	 * @return
	 */
	public int wateringPlants(int[] plants, int capacity) {
		int ans = 0;
		int currentCapacity = capacity;
		for (int i = 0; i < plants.length; i++) {
			int plant = plants[i];
			if (currentCapacity < plant) {
				// 当前距离 * 2 。
				ans += i * 2;
				currentCapacity = capacity;
			}
			ans++;
			currentCapacity -= plant;
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/watering-plants-ii/description/?envType=daily-question&envId=2024-05-09
	 * @param plants
	 * @param capacityA
	 * @param capacityB
	 * @return
	 */
	public int minimumRefill(int[] plants, int capacityA, int capacityB) {
		int ans = 0;
		// 就是要强行模拟这些操作。
		int currentCapacityA = capacityA;
		int currentCapacityB = capacityB;
		int start = 0, end = plants.length - 1;
		while (start <= end) {
			// 特殊处理一下，end - start = 1， end - start = 0的情况。
			if (end - start < 1) {
				int maxCapacity = Math.max(currentCapacityA, currentCapacityB);
				if (maxCapacity < plants[start]) {
					ans++;
				}
				break;
			}
			if (currentCapacityA < plants[start]) {
				currentCapacityA = capacityA;
				ans++;
			}
			if (currentCapacityB < plants[end]) {
				currentCapacityB = capacityB;
				ans++;
			}
			currentCapacityA -= plants[start++];
			currentCapacityB -= plants[end--];
		}
		return ans;
	}
}
