package com.zts.week;

import java.util.PriorityQueue;

/**
 * @Author zhangtusheng
 * @Date 2024 06 23 10 48
 * @describe：
 **/
public class Week403 {

    public static void main(String[] args) {
        Week403 week403 = new Week403();
//        System.out.println(week403.minimumAverage(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
//        System.out.println(week403.minimumArea(new int[][]{{0, 1, 0}, {1, 0, 1}}));
//        System.out.println(week403.minimumArea(new int[][]{{1, 0}, {0, 0}}));
//        System.out.println(week403.minimumArea(new int[][]{{ 0}, {1}}));
//        System.out.println(week403.maximumTotalCost(new int[]{1, -2, 3, 4}));
//        System.out.println(week403.maximumTotalCost(new int[]{1, -1, 1, -1}));
//        System.out.println(week403.maximumTotalCost(new int[]{-14, -13, -20}));

    }


    /**
     * https://leetcode.cn/contest/weekly-contest-403/problems/find-the-minimum-area-to-cover-all-ones-ii/
     * @param grid
     * @return
     */
    public int minimumSum(int[][] grid) {
        // 思路就是穷举线的开始节点。
        return Math.min(f(grid), f(rotate(grid)));
    }

    private int f(int[][] a) {
        int ans = Integer.MAX_VALUE;
        int m = a.length;
        int n = a[0].length;
        if (m >= 3) {
            // 表示可以枚举两条横线
            for (int i = 1; i < m; i++) {
                for (int j = i+1; j < m; j++) {
                    int area = minimumArea(a, 0, i, 0, n);
                    area += minimumArea(a, i, j, 0, n);
                    area += minimumArea(a, j, m, 0, n);
                    ans = Math.min(ans, area);
                }
            }
        }
        if (m >= 2 && n >= 2) {
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    // 计算上面是长方形的湖，下面是竖着的长方形的。
                    int area = minimumArea(a, 0, i, 0, n);
                    area += minimumArea(a, i, m, 0, j);
                    area += minimumArea(a, i, m, j, n);

                    ans = Math.min(ans, area);

                    area = minimumArea(a, i, m, 0, n);
                    area += minimumArea(a, 0, i, 0, j);
                    area += minimumArea(a, 0, i, j, n);
                    ans = Math.min(ans, area);
                }
            }
        }
        return ans;
    }


    private int[][] rotate(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] b = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[j][m - 1 - i] = a[i][j];
            }
        }
        return b;
    }



    /**
     * 求最小面积，当然这个面积是包含对应的1的面积。
     * @param a
     * @param u
     * @param d
     * @param l
     * @param r
     * @return
     */
    private int minimumArea(int[][] a, int u, int d, int l, int r) {
        int left = a[0].length;
        int right = 0;
        int top = a.length;
        int bottom = 0;
        for (int i = u; i < d; i++) {
            for (int j = l; j < r; j++) {
                if (a[i][j] == 1) {
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                    top = Math.min(top, i);
                    bottom = i;
                }
            }
        }
        return (right - left + 1) * (bottom - top + 1);
    }

    /**
     * https://leetcode.cn/contest/weekly-contest-403/problems/maximize-total-cost-of-alternating-subarrays/
     * @param nums
     * @return
     */
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        long ans = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]) + nums[i];
            dp[i][1] = Math.max(dp[i-1][1] + nums[i], dp[i-1][0] - nums[i]);
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }


    /**
     *https://leetcode.cn/contest/weekly-contest-403/problems/find-the-minimum-area-to-cover-all-ones-i/
     * @param grid
     * @return
     */
    public int minimumArea(int[][] grid) {
        int ans = 1;
        // 统计列中是否有1，如果当前列中有1的话，就需要加入到对应的劣种，如果没有就不需要处理。
        int colMin = grid.length, colMax = -1;
        int rowMin = grid[0].length, rowMax = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    colMin = Math.min(j, colMin);
                    colMax = Math.max(j, colMax);
                    rowMin = Math.min(i, rowMin);
                    rowMax = Math.max(i, rowMax);
                }
            }
        }
        return (colMax - colMin + 1) * (rowMax - rowMin + 1);
    }


    /**
     * https://leetcode.cn/contest/weekly-contest-403/problems/minimum-average-of-smallest-and-largest-elements/
     * @param nums
     * @return
     */
    public double minimumAverage(int[] nums) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < nums.length; i++) {
            minQueue.offer(nums[i]);
            maxQueue.offer(nums[i]);
        }
        int n = nums.length;
        double[] result = new double[n/2];
        double ans = Double.MAX_EXPONENT;
        for (int i = 0; i < n/2; i++) {
            Integer poll = minQueue.poll();
            Integer poll1 = maxQueue.poll();
            result[i] = (1.0) * (poll1 + poll) /2.0;
            ans = Math.min(ans, result[i]);
        }
        return ans;
    }
}
