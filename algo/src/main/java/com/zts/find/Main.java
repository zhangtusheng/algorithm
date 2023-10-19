package com.zts.find;

/**
 * @Author zhangtusheng
 * @Date 2023 10 19 01 27
 * @describe：
 **/
public class Main {

    public static void main(String[] args) {

    }


    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5v76yi/
     * @param plants
     * @param target
     * @return
     */
    public boolean findTargetIn2DPlants(int[][] plants, int target) {

        for (int i = 0; i < plants.length; i++) {
            for (int j = 0; j < plants[0].length; j++) {
                if (target == plants[i][j]) {
                    return true;
                }
            }
        }

        return false;

    }


    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/58iqo5/
     * @param records
     * @return
     */
    public int takeAttendance(int[] records) {
        int i = 0, j = records.length - 1;
        while ( i <= j) {
            int m = (j - i ) / 2 + i;
            if (records[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;

    }

    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5874p1/
     * @param scores
     * @param target
     * @return
     */
    public int countTarget(int[] scores, int target) {

        int ans = 0;
        for(int i = 0;i<scores.length;i++) {
            int score = scores[i];
            if (score > target) {
                break;
            }
            if (target == score) {
                ans++;
            }
        }
        return ans;
    }
}
