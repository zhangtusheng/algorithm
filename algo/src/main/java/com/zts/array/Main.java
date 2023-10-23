package com.zts.array;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhangtusheng
 * @Date 2023 10 20 19 18
 * @describe：
 **/
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
       // System.out.println(JSON.toJSONString(main.trainingPlan(new int[]{1, 2, 3, 4, 5})));
        System.out.println(JSON.toJSONString(main.statisticalResult(new int[]{2})));
    }


    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7flqdj/
     * @param array
     * @return
     */
    public int[] spiralArray(int[][] array) {
        if(array.length == 0) return new int[0];
        int l = 0, r = array[0].length - 1, t = 0, b = array.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) res[x++] = array[t][i]; // left to right
            if(++t > b) break;
            for(int i = t; i <= b; i++) res[x++] = array[i][r]; // top to bottom
            if(l > --r) break;
            for(int i = r; i >= l; i--) res[x++] = array[b][i]; // right to left
            if(t > --b) break;
            for(int i = b; i >= t; i--) res[x++] = array[i][l]; // bottom to top
            if(++l > r) break;
        }
        return res;
    }



    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7f04lg/
     * @param arrayA
     * @return
     */
    public int[] statisticalResult(int[] arrayA) {
        int length = arrayA.length;
        if (length == 0) {
            return new int[0];
        }
        if (length == 1){
            return new int[]{0};
        }
        int[] leftSum = new int[arrayA.length];
        int[] rightSum = new int[arrayA.length];
        leftSum[0] = 1;
        rightSum[arrayA.length -1] = 0;
        int sum = 1;
        for (int i = 1; i < arrayA.length; i++) {
            leftSum[i] = sum * arrayA[i-1];
            sum = leftSum[i];
        }
        rightSum[length - 1] =leftSum[length -1];
        sum = 1;
        for (int i = arrayA.length - 2; i >= 0; i--) {
            sum = sum * arrayA[i+1];
            if (i - 1 >=0) {
                rightSum[i] = sum * leftSum[i - 1] * arrayA[i-1];
            } else {
                rightSum[i] = sum;
            }
        }
        return rightSum;
    }

    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fwfti/
     * @param actions
     * @return
     */
    public int[] trainingPlan(int[] actions) {
        int index = 0;
        int currentIndex = 0;
        for (int i = 0; i < actions.length; i++) {
            if (actions[i] % 2 == 1) {
                int tmp = actions[i];
                for(int j = i; j > currentIndex;j--) {
                    actions[j] = actions[j-1];
                }
                actions[currentIndex] = tmp;
                currentIndex++;
            }
        }
        return actions;
    }


    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fdcue/
     * @param target
     * @return
     */
    public int[][] fileCombination(int target) {
        int start = 1;
        int end = 1;
        int sum = 1;
        List<List<Integer>> result = new ArrayList<>();
        while (end < target) {
            if (sum < target) {
                end++;
                sum += end;
            } else if (sum > target){
                sum -= start;
                start++;
            } else {
                List<Integer> currentResult = new ArrayList<>();
                for (int i = start; i <= end ; i++) {
                    currentResult.add(i);
                }
                result.add(currentResult);
                end++;
                sum+=end;
            }
        }
        int[][] ans = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> integers = result.get(i);
            ans[i] = new int[integers.size()];
            for (int j = 0; j < integers.size(); j++) {
                ans[i][j] = integers.get(j);
            }
        }
        return ans;
    }
}
