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

//		System.out.println(main202405.getPermutation(3, 3));

//		System.out.println(main202405.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));

//		System.out.println(JSON.toJSONString(main202405.generateMatrix(3)));

//		int[] nums = {2, 0, 2, 1, 1, 0};
//		main202405.sortColors(nums);
//		System.out.println(JSON.toJSONString(nums));

//		System.out.println(JSON.toJSONString(main202405.combine(3, 3)));
//		System.out.println(JSON.toJSONString(main202405.combine(4, 2)));

//		System.out.println(JSON.toJSONString(main202405.subsets(new int[]{1,2, 3})));

//		System.out.println(JSON.toJSONString(main202405.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED")));
//		System.out.println(JSON.toJSONString(main202405.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB")));

//		int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
//		int i = main202405.removeDuplicates(nums);
//		System.out.println(i);
//		System.out.println(nums);
//		System.out.println(main202405.removeDuplicates(new int[] {1,1,1,2,2,3}));

//		System.out.println(JSON.toJSONString(main202405.subsetsWithDup(new int[]{1, 2, 2})));

//		System.out.println(main202405.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
//		System.out.println(main202405.isInterleave("abababababababababababababababababababababababababababababababababababababababababababababababababbb",
//			"babababababababababababababababababababababababababababababababababababababababababababababababaaaba",
//			"abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb"
//		));

		int[] nums = {1, 2, 3};
//		main202405.nextPermutation(nums);
//		System.out.println(JSON.toJSONString(nums));

//		nums = new int[]{1, 2, 3,4,5};
//		main202405.nextPermutation(nums);
//		System.out.println(JSON.toJSONString(nums));
//
//		nums = new int[]{1, 3, 2};
//		main202405.nextPermutation(nums);
//		System.out.println(JSON.toJSONString(nums));
//
//		nums = new int[]{1, 2, 3};
//		main202405.nextPermutation(nums);
//		System.out.println(JSON.toJSONString(nums));
//
//		nums = new int[]{3, 2, 1};
//		main202405.nextPermutation(nums);
//		System.out.println(JSON.toJSONString(nums));


//		System.out.println(JSON.toJSONString(main202405.findPeaks(new int[] {1, 4, 3, 8, 7, 8})));

		System.out.println(main202405.maximumLength("aabbb"));
		System.out.println(main202405.maximumLength("aaaa"));

	}

	/**
	 * https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-i/?envType=daily-question&envId=2024-05-29
	 * @param s
	 * @return
	 */
	public int maximumLength(String s) {
		int result = -1;
		int n = s.length();
		// 枚举长度
		for (int i = 1; i < n; i++) {
			// 枚举开始节点。
			Map<String, Integer> map = new HashMap<>();
			for (int j = 0; j < n - i + 1; j++) {
				// 并且这段是合法的，才能进行计算。
				String substring = s.substring(j, j + i);
				if (!checkSpecial(substring)) {
					continue;
				}
				map.put(substring, map.getOrDefault(substring, 0) + 1);
			}
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() >= 3) {
					result = Math.max(result, entry.getKey().length());
				}
			}
		}
		return result;
	}

	private boolean checkSpecial(String s) {
		char[] charArray = s.toCharArray();
		for (int i = 1; i < charArray.length; i++) {
			if (charArray[i] != charArray[i-1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * https://leetcode.cn/problems/day-of-the-year/?envType=daily-question&envId=2024-05-28
	 * @param date
	 * @return
	 */
	public int dayOfYear(String date) {
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] split = date.split("-");
		int year = Integer.parseInt(split[0]);
		int month = Integer.parseInt(split[1]);
		int day = Integer.parseInt(split[2]);
		int result = 0;
		for (int i = 0; i < month - 1; i++) {
			result += days[i];
		}
		result += day;
		if (month > 2 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			result++;
		}
		return result;
	}



	/**
	 * https://leetcode.cn/problems/find-the-peaks/?envType=daily-question&envId=2024-05-28
	 * @param mountain
	 * @return
	 */
	public List<Integer> findPeaks(int[] mountain) {
		List<Integer> result = new ArrayList<>();
		int index = 1;
		while (index < mountain.length - 1) {
			if (mountain[index] > mountain[index - 1] && mountain[index] > mountain[index + 1]) {
				result.add(index);
			}
			index++;
		}
		return result;
	}








	/**
	 *
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		if (slow == null) {
			return null;
		}
		// 经过两轮的slow的话，这个就一定是答案。
		ListNode ptr = head;
		int i = 0;
		while ((ptr.next == slow && i == 1)) {
			if (ptr == slow) {
				i = 1;
			}
			ptr = ptr.next;
		}
		return ptr;
	}

	boolean isEnd = false;
	boolean flag = false;
	Set<String> set = new HashSet<>();

	/**
	 * https://leetcode.cn/problems/next-permutation/
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {

		// 可以通过推算来进行计算的。下一个数字一定比当前的大，那么我们要找一个尽可能比这个大的，但是涨幅要小一点的，也就是要从后往前找一个比当前小的数子进行交换。
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);

	}

	private void reverse(int[] nums, int start) {
		int left = start;
		int right = nums.length - 1;
		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/**
	 * https://leetcode.cn/problems/interleaving-string/
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	boolean isInterLeaveFlag;
	public boolean isInterleave(String s1, String s2, String s3) {
		isInterLeaveFlag = false;
		if (s1.length() + s2.length() != s3.length()) {
			return isInterLeaveFlag;
		}
		dfsString(s1, 0, s2, 0, s3, 0);
		return isInterLeaveFlag;
	}

	private void dfsString(String s1, String s2, String s3) {
		boolean[][][] dp = new boolean[s3.length() + 1][s1.length() + 1][s2.length() + 1];
		if (s1.charAt(0) == s3.charAt(0)) {
			dp[1][1][0] = true;
		}
		if (s2.charAt(0) == s3.charAt(0)) {
			dp[1][0][1] = true;
		}
		for (int i = 1; i <= s3.length(); i++) {
			for (int j = 1; j <= i; j++) {
				for (int k = 1; k <= i - j; k++) {
					if (s1.charAt(j - 1) == s3.charAt(i-1)) {
					}
				}
			}
		}

	}

	private void dfsString(String s1, int index1, String s2, int index2, String s3, int index3) {
		if (isInterLeaveFlag) {
			return;
		}
		if (index3 == s3.length()) {
			isInterLeaveFlag = true;
			return;
		}

		// 边界条件。
		if (index1 + index2 >= s3.length()) {
			return;
		}

		if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
			dfsString(s1, index1 + 1, s2, index2, s3, index3 + 1);
		}

		if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
			dfsString(s1, index1, s2, index2 + 1, s3, index3 + 1);
		}
	}



	/**
	 * https://leetcode.cn/problems/subsets-ii/
	 * @param nums
	 * @return
	 *
	 *
	 */
	Map<String, String> existMap = new HashMap<>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());

		existMap = new HashMap<>();
		// 枚举起点。
		for (int i = 0; i < nums.length; i++) {
			// 枚举长度
			for (int j = 1; j <= nums.length; j++) {
				List<Integer> path = new ArrayList<>();
				path.add(nums[i]);
				dfs1(nums, path, result, j, i + 1);
			}
		}
		return result;
	}

	private void dfs1(int[] nums, List<Integer> path, List<List<Integer>> result, int k, int start) {
		if (path.size() == k) {
			String key = "";
			List<Integer> keyList = new ArrayList<>(path).stream().sorted().collect(Collectors.toList());
			for (Integer i1 : keyList) {
				key = key + "," + i1;
			}
			if (existMap.get(key) != null){
				return;
			}
			result.add(new ArrayList<>(path));
			existMap.put(key, key);
			return;
		}
		if (start >= nums.length) {
			return;
		}
		for (int i = start; i <= nums.length - 1 ; i++) {
			path.add(nums[i]);
			dfs1(nums, path, result, k, i + 1);
			path.remove(path.size() - 1);
		}

	}


	/**
	 * https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
	 * @param nums
	 * @param target
	 * @return
	 */
	public boolean search(int[] nums, int target) {
		for (int num : nums) {
			if (num == target) {
				return true;
			}
		}
		return false;
	}

	/**
	 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		// 用作哨兵，也就是最终的结果。
		int index = -1;
		// 当前跟哨兵相同的数量是多少。
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			if (index == -1) {
				nums[++index] = nums[i];
				ans = 1;
				continue;
			}
			if (nums[index] == nums[i]) {
				// 分成两种情况。
				if (ans != 2) {
					nums[++index] = nums[i];
					ans++;
				}
			} else if(nums[index] != nums[i]) {
				nums[++index] = nums[i];
				ans = 1;
			}
		}
		return index + 1;
	}

	/**
	 * https://leetcode.cn/problems/word-search/
	 * @param board
	 * @param word
	 * @return
	 */
	boolean existFlag = false;
	public boolean exist(char[][] board, String word) {
		existFlag = false;
		char[] charArray = word.toCharArray();
		if (word == null || word.length() == 0) {
			return true;
		}
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == charArray[0]) {
					boolean[][] isVisited = new boolean[m][n];
					isVisited[i][j] = true;
					dfs(isVisited, i, j, m, n, charArray, 1, board);
				}
			}
		}
		return existFlag;
	}

	private void dfs(boolean[][] isVisited, int x, int y, int m, int n, char[] charArray, int index, char[][] board) {
		if (existFlag) {
			return;
		}
		if (index == charArray.length) {
			existFlag = true;
			return;
		}
		if (x <0 || y < 0 || x >= m || y>=n) {
			return ;
		}
		//  上面
		if (x - 1>= 0 && !isVisited[x -1][y] && charArray[index] == board[x-1][y]) {
			isVisited[x -1][y] = true;
			dfs(isVisited, x -1, y, m, n, charArray, index + 1, board);
			isVisited[x -1][y] = false;
		}
		// 下面
		if (x + 1< m && !isVisited[x +1][y] && charArray[index] == board[x+1][y]) {
			isVisited[x + 1][y] = true;
			dfs(isVisited, x + 1, y, m, n, charArray, index + 1, board);
			isVisited[x + 1][y] = false;
		}
		// 左边

		if (y - 1 >=0 && !isVisited[x][y - 1] && charArray[index] == board[x][y-1]) {
			isVisited[x][y - 1] = true;
			dfs(isVisited, x, y -1 , m, n, charArray, index + 1, board);
			isVisited[x ][y - 1] = false;
		}
		//右边
		if (y + 1 < n && !isVisited[x][y + 1] && charArray[index] == board[x][y+1]) {
			isVisited[x][y + 1] = true;
			dfs(isVisited, x, y + 1 , m, n, charArray, index + 1, board);
			isVisited[x ][y + 1] = false;
		}
	}

	/**
	 * https://leetcode.cn/problems/subsets/
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		Arrays.sort(nums);
		// 枚举数字的长度。

		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j <= nums.length; j++) {
				List<Integer> path = new ArrayList<>();
				path.add(nums[i]);
				dfs(nums, path, result, j, i + 1);
			}
		}
		return result;
	}


	private void dfs(int[] nums, List<Integer> path, List<List<Integer>> result, int k, int start) {
		if (path.size() == k) {
			result.add(new ArrayList<>(path));
			return;
		}
		if (start >= nums.length) {
			return;
		}
		for (int i = start; i <= nums.length - 1 ; i++) {
			path.add(nums[i]);
			dfs(nums, path, result, k, i + 1);
			path.remove(path.size() - 1);
		}

	}

	/**
	 * https://leetcode.cn/problems/combinations/
	 * @param n
	 * @param k
	 * @return
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			List<Integer> path = new ArrayList<>();
			path.add(i);
			dfs(n, path, result, k, i);
		}
		return result;
	}

	private void dfs(int n, List<Integer> path, List<List<Integer>> result, int k, int start) {
		if (path.size() == k) {
			result.add(new ArrayList<>(path));
			return;
		}
		for (int i = start + 1; i <= n ; i++) {

			path.add(i);
			dfs(n, path, result, k, i);
			path.remove(path.size() - 1);

		}

	}


	/**
	 * https://leetcode.cn/problems/sort-colors/
	 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色
	 * @param nums: 颜色分类排序，不能使用内置函数。可以利用三个指针来进行排序。
	 */
	public void sortColors(int[] nums) {
		int n = nums.length;
		//Arrays.sort(nums);
		int endRed = -1;
		int endWhite = -1;
		for (int i = 0; i < nums.length; i++) {
			// 如果当前是红色的话。
			if (nums[i] == 0) {
				int tmp = nums[endRed+1];
				nums[endRed+1] = nums[i];
				nums[i] = tmp;
				endRed++;
			}
			if (nums[i] == 1) {
				if (endWhite == -1) {
					endWhite = endRed + 1;
				}
				int tmp = nums[endWhite];
				nums[endWhite] = nums[i];
				nums[i] = tmp;
				endWhite++;
			}
		}

	}


	/**
	 * https://leetcode.cn/problems/spiral-matrix-ii/
	 * @param n
	 * @return
	 */
	public int[][] generateMatrix(int n) {
		int[][] ans = new int[n][n];
		int startCol = 0;
		int startRow = 0;
		int endCol = n - 1;
		int endRow = n - 1;
		int num = 1;
		while (startCol <= endCol && startRow <= endRow) {
			// 先处理横向的。
			for (int i = startCol; i <= endCol ; i++) {
				ans[startRow][i] = num++;
			}
			startRow++;

			// 后处理尾部纵向的。
			for (int i = startRow; i <= endRow; i++) {
				ans[i][endCol] = num++;
			}
			endCol--;

			// 处理底部横向。
			if (startCol <= endCol) {
				for (int i = endCol; i >= startCol; i--) {
					ans[endRow][i] = num++;
				}
				endRow--;
			}

			// 处理左边的纵向。
			if (startRow <= endRow) {
				for (int i = endRow; i >= startRow; i--) {
					ans[i][startCol] = num++;
				}
				startCol++;
			}
		}
		return ans;
	}

	/**
	 * https://leetcode.cn/problems/spiral-matrix/
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;
		int startCol = 0;
		int startRow = 0;
		while (startCol <= n && startRow <= m) {
			// 先处理横向的。
			for (int i = startCol; i <= n; i++) {
				ans.add(matrix[startRow][i]);
			}
			startRow++;
			// 处理右边的纵向节点。
			for (int i = startCol + 1; i <= m ; i++) {
				ans.add(matrix[i][n]);
			}
			n--;
			// 处理底下的横向节点。
			if (startRow <= m) {
				for (int i = n; i >= startCol; i--) {
					ans.add(matrix[m][i]);
				}
				m--;
			}
			// 处理左边的纵向节点。
			if (startCol <= n) {
				for (int i = m; i >= startRow; i--) {
					ans.add(matrix[i][startCol]);
				}
				startCol++;
			}

		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/permutation-sequence/
	 * @param n
	 * @param k
	 * @return
	 */
	List<Integer> ansResult;
	int count = 0;
	public String getPermutation(int n, int k) {
		ansResult = new ArrayList<>();
		count = 0;
		dfs(n, new boolean[n + 1], new ArrayList<>(), k);
		return ansResult.stream().map(String::valueOf).collect(Collectors.joining());
	}

	/**
	 * 这个方式会出现超时。
	 * @param n
	 * @param isUsed
	 * @param path
	 */
	private void dfs(int n, boolean[] isUsed, List<Integer> path, int k) {
		if (path.size() == n) {
			count++;
			if (count == k) {
				ansResult = new ArrayList<>(path);
			}
			return ;
		}
		for (int i = 1; i <= n; i++) {
			if (isUsed[i]) {
				continue;
			}
			if (count == k) {
				return;
			}
			path.add(i);
			isUsed[i] = true;
			dfs(n, isUsed, path, k);
			path.remove(path.size() - 1);
			isUsed[i] = false;
		}
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

	public void dfs(int[] nums, int[] sortNums, int length, boolean[] used, List<Integer> path, List<Integer> result, boolean flag) {
		if (length == nums.length) {
			List<String> stringPath = new ArrayList<>();
			for (Integer i : path) {
				stringPath.add(i.toString());
			}
			if (Arrays.equals(nums, path.stream().mapToInt(Integer::intValue).toArray())) {
				flag = true;
			} else if (flag) {
				if (set.contains(String.join(",", stringPath.toArray(new String[0])))) {
					return;
				}
				// 记录当前结果。
				result.addAll(new ArrayList<>(path));
				isEnd = true;
			}
			set.add(String.join(",", stringPath.toArray(new String[0])));
			return;
		}
		for (int i = 0; i < sortNums.length; i++) {
			if (isEnd) {
				return;
			}
			if (used[i]) {
				continue;
			}
			if (nums[length] < sortNums[i]) {
				continue;
			}
			if (nums[length] > sortNums[i]) {
				flag = true;
			}
			used[i] = true;
			path.add(sortNums[i]);
			dfs(nums, sortNums, length + 1, used, path, result, flag);
			used[i] = false;
			path.remove(path.size() - 1);
		}
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
