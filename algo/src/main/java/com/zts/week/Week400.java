package com.zts.week;

import java.util.*;

/**
 * @Author zhangtusheng
 * @Date 2024 06 02 10 25
 * @describe：
 **/
public class Week400 {

    public static void main(String[] args) {
        Week400 week = new Week400();

//        System.out.println(week.minimumChairs("ELEELEELLL"));
//        System.out.println(week.countDays(10, new int[][]{{1, 3}, {5, 7}, {9, 10}}));
//        System.out.println(week.countDays(5, new int[][]{{2, 4}, {1, 3}}));
//        System.out.println(week.clearStars("ab**c"));
//        System.out.println(week.clearStars("aaba*"));
//        System.out.println(week.clearStars("de*"));

//        System.out.println(week.minimumDifference(new int[]{1, 2, 4, 5}, 3));
        System.out.println(week.minimumDifference(new int[]{3, 1, 7}, 4));
        System.out.println(week.minimumDifference(new int[]{5,13,90,92,49}, 10));
    }


    /**
     * https://leetcode.cn/contest/weekly-contest-400/problems/find-subarray-with-bitwise-and-closest-to-k/
     * @param nums
     * @param k
     * @return
     */
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            result = Math.min(result, Math.abs(k - x));
            for (int j = i -1 ; j >= 0 && ((nums[j] & x) != nums[j]) ; j--) {
                nums[j] &= x;
                result = Math.min(result, Math.abs(k - nums[j]));
            }
        }

        // 对于当前的值来说，有两种情况，就是取跟不取的情况，看看是那个比较好。
        return result;
    }


    /**
     * https://leetcode.cn/contest/weekly-contest-400/problems/lexicographically-minimum-string-after-removing-stars/
     * @param s
     * @return
     */
    public String clearStars(String s) {
        Map<Integer, Integer> existMap = new HashMap<>();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                // 寻找最小的字符串，然后判断字符串是否被删除了。
                List<Integer> deleteIndex = null;
                for (int j = 0; j < 26; j++) {
                    char b = (char) ('a' + j);
                    if (map.get(b) != null && map.get(b).size() > 0) {
                        deleteIndex = map.get(b);
                        break;
                    }
                }
                if (deleteIndex != null) {
                    int index = deleteIndex.size() - 1 ;
                    deleteIndex.remove(index);
                }
            } else {
                map.put(c, map.getOrDefault(c, new ArrayList<>()));
                map.get(c).add(i);
            }
        }
        for (Map.Entry<Character, List<Integer>> characterListEntry : map.entrySet()) {
            List<Integer> value = characterListEntry.getValue();
            for (Integer integer : value) {
                existMap.put(integer, integer);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (existMap.get(i) != null) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }


    /**
     * https://leetcode.cn/contest/weekly-contest-400/problems/count-days-without-meetings/
     * @param days
     * @param meetings
     * @return
     */
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        int ans = 0;
        int start = 0;
        for (int i = 0; i < meetings.length; i++) {
            int[] meeting = meetings[i];
            if (meeting[0] > start) {
                ans += meeting[0] - start - 1;
            }
            start = Math.max(start, meeting[1]);
        }
        if (start != days) {
            ans += days - start;
        }
        return ans;
    }


    /****
     * https://leetcode.cn/contest/weekly-contest-400/problems/minimum-number-of-chairs-in-a-waiting-room/
     * @param s
     * @return
     */
    public int minimumChairs(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c =='E' && stack.isEmpty()) {
                ans++;
            } else if (c == 'E' && !stack.isEmpty()) {
                stack.pop();
            } else if (c == 'L') {
                stack.push(1);
            }
        }
        return ans;
    }
}
