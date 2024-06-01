package com.zts.week;

import java.util.*;

/**
 * @Author zhangtusheng
 * @Date 2024 05 26 11 09
 * @describe：
 **/
public class Week399 {

    public static void main(String[] args) {
        Week399 week399 = new Week399();
        int[] nums1 = {1,3, 4};
        int[] nums2 = {1, 3, 4};
        int k = 1 ;
        System.out.println(week399.numberOfPairs1(nums1,nums2,k));

        //System.out.println(week399.compressedString("aabcccccaaa"));
//        System.out.println(week399.compressedString("abcde"));
//        System.out.println(week399.compressedString("aaa"));
//        System.out.println(week399.compressedString("aaaaaaaaaaaaaabb"));


    }

    public long numberOfPairs1(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        Arrays.sort(nums2);
        Arrays.sort(nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(nums2[i] * k, i);
        }
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {

        }
        return ans;
    }




    /**
     * https://leetcode.cn/contest/weekly-contest-399/problems/string-compression-iii/
     * @param word
     * @return
     */
    public String compressedString(String word) {
        String result = "";
        char[] chars = word.toCharArray();
        Stack<Character> stack = new Stack<>();
        int ans = 1;
        stack.push(chars[0]);
        for (int i = 1; i < word.length(); i++) {
            if (chars[i] == stack.peek()) {
                ans++;
                if (ans > 9) {
                    ans = ans - 9;
                    result = result + "9" + stack.peek();
                }
            } else {
                result = result + ans + stack.peek();
                stack.pop();
                stack.push(chars[i]);
                ans = 1;
            }
        }
        if (!stack.isEmpty()) {
            result = result + ans + stack.peek();
        }

        return result;
    }

    /**
     *https://leetcode.cn/contest/weekly-contest-399/problems/find-the-number-of-good-pairs-i/
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((nums1[i] % (nums2[j] * k) == 0)) {
                    ans++;
                }
            }
        }
        return ans;
    }


}
