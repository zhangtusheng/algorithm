package com.zts.week;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @Author zhangtusheng
 * @Date 2023 10 22 10 31
 * @describe：
 **/
public class Week368 {

    public static void main(String[] args) {

        Week368 week368 = new Week368();
        System.out.println(JSON.toJSONString(week368.minGroupsForValidAssignment(new int[]{1,1,3,3,1,1,2,2,3,1,3,2})));
    }

    /**
     * https://leetcode.cn/contest/weekly-contest-368/problems/minimum-number-of-groups-to-create-a-valid-assignment/
     * @param nums
     * @return
     */
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // 给每个组都确定下有多少个相同的数据。
        for (int num : nums) {
            Integer i = map.getOrDefault(num, 0);
            i++;
            map.put(num, i);
        }
        int[] newNums = new int[map.size()];
        int index = 0;
        int k = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            newNums[index++] = integerIntegerEntry.getValue();
            k = Math.min(k, integerIntegerEntry.getValue());
        }
        for (; ; k--) {
            int ans = 0;
            for (int c : newNums) {
                if (c / k < c % k) {
                    ans = 0;
                    break;
                }
                ans += (c + k) / (k + 1);
            }
            if (ans != 0) {
                return ans;
            }
        }

    }



    /**
     * https://leetcode.cn/contest/weekly-contest-368/problems/minimum-sum-of-mountain-triplets-i/
     * @param nums
     * @return
     */
    public int minimumSum(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]<nums[j] && nums[k]<nums[j]) {
                        ans = Math.min(ans, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }


    /**
     * https://leetcode.cn/contest/weekly-contest-368/problems/minimum-sum-of-mountain-triplets-ii/
     * @param nums
     * @return
     */
    public int minimumSum1(int[] nums) {
        // 左边维护一个单调递减的栈，右边也是维护一个这样的栈
        PriorityQueue<Integer> stack = new PriorityQueue<>();
        int length = nums.length;
        stack.offer(nums[0]);
        int ans = Integer.MAX_VALUE;
        int[] right = new int[length];
        right[length - 1] = 0;
        PriorityQueue<Integer> stack1 = new PriorityQueue<>();
        stack1.offer(nums[length -1]);
        for (int i = length -2; i >=0 ; i--) {
            right[i] = stack1.peek();
            stack1.offer(nums[i]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            Integer leftValue = stack.peek();
            Integer rightValue = right[i];
            if (leftValue < nums[i] && rightValue < nums[i]) {
                ans = Math.min(ans, leftValue + rightValue + nums[i]);
            }
            stack.offer(nums[i]);
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;

    }
}
