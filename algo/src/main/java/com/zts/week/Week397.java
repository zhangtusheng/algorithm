package com.zts.week;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangtusheng
 * @Date 2024 05 12 14 45
 * @describe：
 **/
public class Week397 {

    public static void main(String[] args) {
        Week397 week397 = new Week397();
        //System.out.println(week397.findPermutationDifference("rwohu", "rwuoh"));
        System.out.println(week397.maximumEnergy(new int[]{-2, -3, -1}, 2));
    }


    /**
     * https://leetcode.cn/problems/taking-maximum-energy-from-the-mystic-dungeon/
     * @param energy
     * @param k
     * @return
     */
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        dp[0] = energy[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + energy[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j += k) {
                sum += energy[j];
                ans = Math.max(ans, sum + (j + k < n ? dp[j + k] : 0));
            }
        }
        return ans;
    }


    /**
     * https://leetcode.cn/problems/permutation-difference-between-two-strings/
     * @param s
     * @param t
     * @return
     */
    public int findPermutationDifference(String s, String t) {
        int ans = 0;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s1[i], i);
        }
        for (int i = 0; i < s.length(); i++) {
            ans += Math.abs(i - map.get(t1[i]));
        }
        return ans;
    }
}
