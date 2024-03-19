package com.zts.week;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangtusheng
 * @Date 2023 10 29 10 42
 * @describe：
 **/
public class Week369 {


    public static void main(String[] args) {
        Week369 week369 = new Week369();
        System.out.println(week369.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }


    /**
     * https://leetcode.cn/contest/weekly-contest-369/problems/find-the-k-or-of-an-array/
     * @param nums
     * @param k
     * @return
     */
    public int findKOr(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        return 0;
    }


    public int maxProduct(String[] words){
        boolean[][] nums = new boolean[words.length][26];
        for (int j = 0; j < words.length; j++) {
            char[] charArray = words[j].toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                nums[j][charArray[i] - 'a'] = true;
            }
        }
        int max = 0;
        for(int i = 0;i<words.length;i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!hasSameChar(nums[i], nums[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;

    }

    private boolean hasSameChar(boolean[] s1, boolean[] s2) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] && s2[i]) {
                return true;
            }
        }
        return false;
    }
}
