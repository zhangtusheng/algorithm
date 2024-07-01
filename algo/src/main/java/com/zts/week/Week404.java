package com.zts.week;

import java.util.Stack;
import java.util.concurrent.CompletableFuture;

/**
 * @Author zhangtusheng
 * @Date 2024 06 30 10 48
 * @describe：
 **/
public class Week404 {

    public static void main(String[] args) {
        Week404 week404 = new Week404();
//        System.out.println(week404.maxHeightOfTriangle(2, 4));
//        System.out.println(week404.maxHeightOfTriangle(2, 1));
        System.out.println(week404.maximumLength(new int[]{1, 2, 3, 4}, 2));
//        System.out.println(week404.maximumLength(new int[]{1}));
        // A生成了1，2，3，4
        /// 1，2，3，4
    }


    /**
     * https://leetcode.cn/contest/weekly-contest-404/problems/find-the-maximum-length-of-valid-subsequence-ii/
     * @param nums
     * @param k
     * @return
     */
    public int maximumLength(int[] nums, int k) {
        int[] t = new int[nums.length];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            t[i] = nums[i]% k;
        }
        int ans = 0;
        // 枚举求膜的值是多少。
        for (int i = 0; i < k; i++) {
            // 从那里开始。
            for (int j = 0; j < n; j++) {
                Stack<Integer> stack = new Stack<>();
                stack.push(t[j]);
                for (int l = j + 1; l < n; l++) {
                    if ((stack.peek() + t[l]) % k == i) {
                        stack.push(t[l]);
                    }
                }
                ans = Math.max(ans, stack.size());
            }
        }
        return ans;
    }


    /**
     * https://leetcode.cn/contest/weekly-contest-404/problems/find-the-maximum-length-of-valid-subsequence-i/
     * @param nums
     * @return
     */
    public int maximumLength(int[] nums) {
        int ans = 0;
        int[] k = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            k[i] = nums[i] % 2;
        }
        // 无非就是4种情况，要么全是一样的，要么是1，0，要么是0，1；
        // 取0的情况。
        int zero = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (k[i] == 0) {
                zero++;
            }
        }
        int one = 0;
        for (int i = 0; i < n; i++) {
            if (k[i] == 1) {
                one++;
            }
        }
        ans = Math.max(one, zero);
        // 从0开始到1的情况。
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for (int i = 0; i < n; i++) {
            if ((stack.peek() ^ k[i]) !=0) {
                stack.push(k[i]);
            }
        }
        ans = Math.max(ans, stack.size() - 1);

        // 1开始
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(0);
        for (int i = 0; i < n; i++) {
            if ((stack1.peek() ^ k[i]) !=0) {
                stack1.push(k[i]);
            }
        }
        ans = Math.max(ans, stack1.size() - 1);
        return ans == 1 ? 0 : ans;
    }


    public int maxHeightOfTriangle(int red, int blue) {
        // 强行模拟
        boolean flag = false;
        int i = 1, level = 0;
        // 假设从蓝色开始。
        int newRed = red, newBlue = blue;
        while (newRed > 0 && newBlue > 0) {
            // 当前需要处理的是什么颜色。
            if (flag) {
                if (i > newBlue) {
                    break;
                }
                newBlue -= i;
            } else {
                if (i > newRed) {
                    break;
                }
                newRed -= i;
            }
            i++;
            level++;
            flag = !flag;
        }
        if (newBlue > 0 && flag && newBlue >= i) {
            i++;
            level++;
        }
        if (newRed >0 && (!flag) && newRed >= i) {
            level++;
            i++;
        }
        int ans = level;
        i = 1;
        flag = false;
        newRed = red;
        newBlue = blue;
        level = 0;
        while (newRed > 0 && newBlue > 0) {
            // 当前需要处理的是什么颜色。
            if (flag) {
                if (i > newRed) {
                    break;
                }
                newRed -= i;
            } else {
                if (i > newBlue) {
                    break;
                }
                newBlue -= i;
            }
            i++;
            level++;
            flag = !flag;
        }
        if (newRed > 0 && flag && newRed >= i) {
            i++;
            level++;
        }
        if (newBlue >0 && (!flag) && newBlue >= i) {
            i++;
            level++;
        }
        return Math.max(level, ans);
    }
}
