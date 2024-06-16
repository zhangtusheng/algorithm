package com.zts.week;

import java.util.*;

/**
 * @Author zhangtusheng
 * @Date 2024 06 16 10 45
 * @describe：
 **/
public class Week402 {

    public static void main(String[] args) {
        Week402 week402 = new Week402();
        //System.out.println(week402.countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
        //System.out.println(week402.countCompleteDayPairs(new int[]{13, 11}));
//        System.out.println(week402.maximumTotalDamage(new int[]{5,9,2,10,2,7,10,9,3,8}));
//        System.out.println(week402.maximumTotalDamage(new int[]{7,1, 6,6}));
//        System.out.println(week402.countOfPeaks(new int[]{3, 1, 4, 2, 5}, new int[][]{{2,3,4},{1,0,4}}));
//        System.out.println(week402.countOfPeaks(new int[]{4,1,4,2,1,5}, new int[][]{{2,2,4},{1,0,2},{1,0,4}}));
//        System.out.println(week402.countOfPeaks(new int[]{5,4,8,6}, new int[][]{{1, 2, 2},{1,1,2},{2, 1, 6}}));
//        System.out.println(week402.countOfPeaks(new int[]{4,9,4,10,7}, new int[][]{{2,3,2},{2,1,3},{1,2,3}}));
//        System.out.println(week402.countOfPeaks(new int[]{8,10,10,9,10}, new int[][]{{2,0,1},{2,2,7},{1,0,2}}));
        System.out.println(week402.countOfPeaks(new int[]{6, 7, 4}, new int[][]{{1, 2, 2},{2, 2, 8},{1,0,2}, {1, 1, 1}, {1, 0, 0}}));
    }

    /**
     * https://leetcode.cn/contest/weekly-contest-402/problems/peaks-in-array/
     * @param nums: 感觉是树状数组。
     * @param queries
     * @return
     */
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        ArrayTree f = new ArrayTree(n - 1);
        for (int i = 1; i < n - 1; i++) {
            update(f, nums, i, 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                ans.add(f.query(q[1] + 1, q[2] - 1));
                continue;
            }
            int i = q[1];
            for (int j = Math.max(i - 1, 1); j <= Math.min(i+1, n - 2); j++) {
                update(f, nums, j, -1);
            }
            nums[i] = q[2];
            for (int j = Math.max( i - 1, 1); j <= Math.min(i+1, n -2) ; j++) {
                update(f, nums, j, 1);
            }
        }
        return ans;
    }

    private void update(ArrayTree f, int[] nums, int i, int val) {
        if (nums[i - 1] < nums[i] && nums[i] > nums[i+1]) {
            f.update(i, val);
        }
    }


    public static class ArrayTree{
        private final int[] f;

        public ArrayTree(int n) {
            f = new int[n];
        }

        void update(int i, int value) {
            for (; i< f.length; i+= i & -i) {
                f[i] += value;
            }
        }

        private int pre(int i) {
            int res = 0;
            for (; i> 0; i &=i-1) {
                res += f[i];
            }
            return res;
        }

        int query(int l, int r) {
            if (r < l) {
                return 0;
            }
            return pre(r) - pre(l - 1);
        }
    }

    private List<Integer> getIntegers(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] isTop = new boolean[n];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                isTop[i] = true;
            }
        }
        int[] sum = new int[n];
        for (int i = 1; i < n ; i++) {
            sum[i] = sum[i-1] + (isTop[i] ? 1 : 0);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            // 查询操作
            if (queries[i][0] == 1) {
                result.add(getSum(sum, queries[i][1], queries[i][2], isTop));
            } else{
                // 更新操作。
                int left = queries[i][1];
                int value = queries[i][2];
                nums[left] = value;
                for (int j = left; j < n  ; j++) {
                    if (j == 0) {
                        continue;
                    }
                    // 会影响到前面两个的一个峰值。
                    if (j -2 >= 0) {
                        if (nums[j-2] < nums[j-1] && nums[j-1] > nums[j]) {
                            isTop[j-1] = true;
                            sum[j-1] = sum[j-2] + 1;
                        }
                    }
                    if (nums[j-1] <= nums[j]) {
                        isTop[j - 1] = false;
                        sum[j - 1] = j - 2 >= 0 ? sum[j-2] : 0;
                    }
                    if (j+ 1 < n && nums[j - 1] < nums[j] && nums[j] > nums[j + 1]) {
                        isTop[j] = true;
                    } else {
                        isTop[j] = false;
                    }
                    sum[j] = sum[j - 1] + (isTop[j] ? 1 : 0);
                }
                sum[n-1] = sum[n-2];
            }
        }
        return result;
    }


    private int getSum(int[] sum , int left, int right, boolean[] isTop) {
        if (right == left) {
            return 0;
        }
        if (isTop[left]) {
            left++;
        }
        if (isTop[right]) {
            right--;
        }
        return sum[right] - sum[left];
    }



    /**
     * https://leetcode.cn/contest/weekly-contest-402/problems/maximum-total-damage-with-spell-casting/
     * @param power
     * @return
     */
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int n = power.length;
        long[][] dp = new long[n][2];
        dp[0][0] = 0;
        dp[0][1] = power[0];
        long ans = Math.max(dp[0][0], dp[0][1]);
        for (int i = 1; i < n; i++) {
            // 对于当前节点来说有两种情况，可取或者不可取的最大值是多少。
            // 当前节点要取的话，判断前一个节点是否可取。如果前一个节点是可取的话，那么当前节点可能的最大值。
            if (power[i] == power[i-1] + 1 || power[i] == power[i-1] + 2) {
                int j = i - 1;
                while (j >= 0 && (power[i] == power[j] + 1 || power[i] == power[j] + 2)) {
                    j --;
                }
                if (j < 0) {
                    dp[i][1] = power[i];
                } else {
                    // 特判一下，如果是跟前一个相同的话，那么就可能是需要进行前一个想加的。
                    dp[i][1] = Math.max(dp[j][0], dp[j][1]) + power[i];

                }
            } else {
                if (power[i] == power[i-1]) {
                    dp[i][1] = dp[i-1][1] + power[i];
                } else {
                    dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + power[i];
                }
            }
            // 如果当前节点不可取的话，那么就是dp[i-1][0]了。
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }

    /**
     * https://leetcode.cn/contest/weekly-contest-402/problems/count-pairs-that-form-a-complete-day-ii/
     * @param hours
     * @return
     */
    public long countCompleteDayPairs(int[] hours) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            hours[i] = hours[i] % 24;
            map.put(hours[i], map.getOrDefault(hours[i], 0) + 1);
        }
        for (int i = 0; i <= 12; i++) {
            if (map.containsKey(i)) {
                // 存在的时候进行处理。
                if (i == 0 || i == 12) {
                    // 都是取了自己的。
                    Integer integer = map.get(i);
                    if (integer > 1) {
                        ans = ans + ((long) integer * (integer - 1) / 2);
                    }
                } else {
                    Integer integer = map.get(i);
                    Integer integer1 = 24 - i;
                    if (map.containsKey(integer1)) {
                        ans += ((long)integer * (long)map.get(integer1));
                    }
                }
            }
        }
        return ans;
    }

    /**
     * https://leetcode.cn/contest/weekly-contest-402/problems/count-pairs-that-form-a-complete-day-i/
     * @param hours
     * @return
     */
    public int countCompleteDayPairs1(int[] hours) {
        int ans = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    ans++;
                }
            }
        }
        return ans;

    }
}
