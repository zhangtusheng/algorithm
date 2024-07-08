package com.zts.struct;

/**
 * @Author zhangtusheng
 * @Date 2024 07 01 23 23
 * @describe：
 **/
public class NumArray {
    private int[] tree;
    private int[] nums;


    public NumArray(int[] nums) {
        tree = new int[nums.length + 1];
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int delta = val - nums[index];
        nums[index] = val;
        // 因为求和的下表是从i+1开始的。
        // 比如现在的长度是12，101 +
        for (int i = index + 1; i < tree.length; i += i & (-i)) {
            tree[i] += delta;
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }

    private int prefixSum(int i) {
        int s = 0;
        while (i > 0) {
            s += tree[i];
            i &= (i - 1);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(8 & (-8));
    }

}
