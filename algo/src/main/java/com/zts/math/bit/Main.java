package com.zts.math.bit;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhangtusheng
 * @Date 2023 10 18 20 18
 * @describe：
 **/
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        //System.out.println(main.encryptionCalculate(5, -1));
        //System.out.println(JSON.toJSON(main.sockCollocation(new int[]{4, 4, 6, 6, 2, 3})));
        int a = 1, b = 1, c = 1;
        System.out.println(a ^ b ^ c);
    }


    /**
     *
     * @param actions
     * @return
     */
    public int trainingPlan(int[] actions) {
        int[] counts = new int[32];
        for(int action : actions) {
            for(int i = 0; i < 32; i++) {
                counts[i] += action & 1; // 更新第 i 位 1 的个数之和
                action >>= 1;            // 第 i 位 --> 第 i 位
            }
        }
        int res = 0, m = 3;
        for(int i = 31; i >= 0; i--) {
            res <<= 1;
            res |= counts[i] % m;        // 恢复第 i 位
        }
        return res;
    }



    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/eubbnm/
     * @param sockets： 如果两个不同的数字，那么必定会出现在某一位上出现不同，我们只要根据这个不同来找出对应的就好了。
     * @return®
     */
    public int[] sockCollocation(int[] sockets) {
        int x = 0, y = 0;
        int sum = sockets[0];
        for (int i = 1; i < sockets.length; i++) {
            sum = sum ^ sockets[i];
        }
        int m = 1;
        while ((m & sum) == 0) {
            m = m << 1;
        }
        for (int socket : sockets) {
            if ((socket & m) != 0) x ^= socket;
            else y ^= socket;
        }
        return new int[]{x, y};
    }


    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5vz6d1/
     * @param dataA
     * @param dataB
     * @return
     */
    public int encryptionCalculate(int dataA, int dataB) {
        if (dataA == 0) return dataB;
        if (dataB == 0) return dataA;
        return encryptionCalculate(dataA ^ dataB, (dataA & dataB) << 1);
    }

    /**
     *https://leetcode.cn/leetbook/read/illustration-of-algorithm/5vk1l3/
     * @param n ： 其实可以利用 n & (n-1) 把最低位的1变成0.
     * @return
     */
    public int hammingWeight(int n) {

        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n = n >>> 1;
        }
        return ans;

    }
}
