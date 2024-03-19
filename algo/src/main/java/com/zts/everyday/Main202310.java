package com.zts.everyday;

import java.util.*;
import java.util.Arrays;

import com.zts.struct.UnionFind;

/**
 * @author zts
 * @date 2023/10/19 10:03
 * @Description : 10月份
 */
public class Main202310 {

	public static void main(String[] args) {
		Main202310 main = new Main202310();
		//System.out.println(main.tupleSameProduct(new int[] {1,2,4,5,10}));
		//System.out.println(JSON.toJSONString(main.countPairs(7, new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}})));
		System.out.println(main.hIndex(new int[]{0, 1, 3, 5, 6}));
		System.out.println(main.hIndex(new int[]{1, 2, 100}));

		//System.out.println(main.tupleSameProduct(new int[] {1,2,4,5,10}));
		System.out.println(main.punishmentNumber(37));
	}


	/**
	 * https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/?envType=daily-question&envId=2023-10-28
	 * @param n
	 * @return
	 */
	public int punishmentNumber(int n) {
		int ans = 0;
		for(int i = 1;i<=n;i++) {
			int sum = i * i;
			boolean check = check(i, sum);
			if (check) {
				ans+=i*i;
			}
		}
		return ans;

	}

	private boolean check(int i, int sum) {
		int ans = 0;
		while (sum > 0) {
			ans += sum % 10;
			sum = sum /10;
		}
		return ans == i;
	}

	/**
	 * https://leetcode.cn/problems/count-the-digits-that-divide-a-number/?envType=daily-question&envId=2023-10-28
	 * @param num
	 * @return
	 */
	public int countDigits(int num) {
		int ans = 0;
		int n = num;
		while (n > 0) {
			int mod = n % 10;
			n = n / 10;
			if (num % mod == 0) {
				ans ++;
			}
		}
		return ans;

	}


	/**
	 * https://leetcode.cn/problems/take-gifts-from-the-richest-pile/?envType=daily-question&envId=2023-10-28
	 * @param gifts
	 * @param k
	 * @return
	 */
	public long pickGifts(int[] gifts, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b -a);
		for (int i = 0; i < gifts.length; i++) {
			queue.offer(gifts[i]);
		}
		for (int i = 0; i < k; i++) {
			Integer peek = queue.poll();
			int value = (int)Math.sqrt(peek);
			queue.offer(value);
		}
		long ans = 0;
		while (!queue.isEmpty()) {
			ans += queue.poll();
		}
		return ans;

	}


	/**
	 * https://leetcode.cn/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/?envType=daily-question&envId=2023-10-27
	 * @param h
	 * @param w
	 * @param horizontalCuts
	 * @param verticalCuts
	 * @return
	 */
	public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);
		int col = 0;
		int start = 0;
		for (int i = 0;i < verticalCuts.length;i++) {
			int value = verticalCuts[i];
			int distance = value -  start;
			col = Math.max(col, distance);
			start = value;
		}
		col = Math.max(w - start, col);
		start = 0;
		int row = 0;
		for (int i = 0;i < horizontalCuts.length;i++) {
			int value = horizontalCuts[i];
			int distance = value -  start;
			row = Math.max(row, distance);
			start = value;
		}
		row = Math.max(row, h - start);
		long rw = row;
		long cl = col;
		return (int) ((rw * cl) % (1000000000 + 7));
	}


	/**
	 * https://leetcode.cn/problems/number-of-senior-citizens/?envType=daily-question&envId=2023-10-21
	 * @param details
	 * @return
	 */
	public int countSeniors(String[] details) {
		int ans = 0;
		for (String detail : details) {
			Integer age = Integer.valueOf(detail.substring(11, 13));
			if (age > 60) {
				ans++;
			}
		}
		return ans;
	}


	/**
	 * https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/?envType=daily-question&envId=2023-10-21
	 * @param n
	 * @param edges
	 * @return： 想法，将数据放入到对应的节点进行遍历，这样已经能遍历过的节点就不用管了。然后计算能当前不跟当前节点在同一个连通图里面的节点。
	 */
	public long countPairs(int n, int[][] edges) {
		UnionFind uf = new UnionFind(n);
		for (int[] edge : edges) {
			int x = edge[0], y = edge[1];
			uf.union(x, y);
		}
		long res = 0;
		for (int i = 0; i < n; i++) {
			res += n - uf.getSize(uf.find(i));
		}
		return res / 2;
	}


	/**
	 * https://leetcode.cn/problems/h-index-ii/?envType=daily-question&envId=2023-10-30
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
		int length = citations.length;
		if (length == 1) {
			return 1;
		}
		int start = length - 1;
		while (citations[start] >= length - start) {
			start--;
		}
		return start + 1;
	}

	private int midFind(int[] citations) {
		return 0;
	}

	/**
	 * https://leetcode.cn/problems/tuple-with-same-product/?envType=daily-question&envId=2023-10-19
	 * @param nums
	 * @return
	 */
	public int tupleSameProduct(int[] nums) {
		Arrays.sort(nums);

		int sum = 0;
		for(int i = 0 ;i<nums.length;i++) {
			for (int j = nums.length -1;j>i;j--) {
				int target = nums[i] * nums[j];
				for(int k = i + 1;k<j;k++) {
					int i1 = target % nums[k];
					if (i1 == 0) {
						int value = target / nums[k];
						if (value != nums[k]) {
							int i2 = find(nums, k + 1, j - 1, value);
							if (i2 < j && i2 > k && nums[i2] == value) {
								sum += 8;
							}
						}
					}
				}
			}
		}
		return sum;
	}

	private int find(int[] nums, int start, int end, int target) {
		while (start < end) {
			int mid = (end - start) / 2 + start;
			if (nums[mid] < target) start = mid + 1;
			else if (nums[mid] > target) end = mid - 1;
			else return mid;
		}
		return start;
	}
}
