package com.zts.sort;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhangtusheng
 * @Date 2023 10 19 12 44
 * @describe：
 **/
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {2, 4, 3, 5, 1};
        main.mergeSort(nums, 0, 4);
        System.out.println(JSON.toJSONString(nums));
    }


    /**
     * 快速排序。
     * @param nums
     * @param l
     * @param r
     */
    void quickSort(int[] nums, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r) return;
        // 哨兵划分操作
        int i = partition(nums, l, r);
        // 递归左（右）子数组执行哨兵划分
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    int partition(int[] nums, int l, int r) {
        // 以 nums[l] 作为基准数
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) j--;
            while (i < j && nums[i] <= nums[l]) i++;
            swap(nums, i, j);
        }
        swap(nums, i, l);
        return i;
    }

    void swap(int[] nums, int i, int j) {
        // 交换 nums[i] 和 nums[j]
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    /**
     * 归并排序。
     * @param nums
     * @param l
     * @param r
     */
    void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        int[] tmp = new int[r - l + 1];
        for(int i = l;i<=r;i++) {
            tmp[i-l] = nums[i];
        }
        int i = 0, j = mid - l + 1;
        for (int k = l; k <= r; k++) {  // 遍历合并左/右子数组
            if (i == mid - l + 1)
                nums[k] = tmp[j++];
            else if (j == r - l + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
            }
        }


    }


}
