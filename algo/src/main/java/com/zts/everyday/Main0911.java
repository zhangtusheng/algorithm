package com.zts.everyday;

import com.zts.model.TreeNode;

import java.util.Arrays;

/**
 * @Author zhangtusheng
 * @Date 2023 09 11 23 25
 * @describe：
 **/
public class Main0911 {

    public static void main(String[] args) {
        Main0911 main0911 = new Main0911();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(main0911.rob(root));
    }

    /**
     * https://leetcode.cn/problems/house-robber-iv/?envType=daily-question&envId=2023-09-19
     * @param nums
     * @param k
     * @return
     */
    public int minCapability(int[] nums, int k) {
        return 0;
    }


    /**
     *https://leetcode.cn/problems/course-schedule-iii/?envType=daily-question&envId=2023-09-11
     * @param courses
     * @return
     */
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int start = 0;
        int ans = 0;
        for (int i = 0; i < courses.length; i++) {
            if (courses[i][0] >= start && courses[i][0] <= courses[i][1]) {
                ans++;
                start = courses[i][1];
            }
        }
        return ans;
    }


    /**
     * https://leetcode.cn/problems/house-robber-iii/?envType=daily-question&envId=2023-09-18
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 优先计算左边的东西，然后在计算右边的东西。
        NewTreeNode dfs = dfs(root);
        return Math.max(dfs.value1, dfs.value2);

    }

    private NewTreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        NewTreeNode newTreeNode = new NewTreeNode();
        if (root.left == null && root.right == null) {
            newTreeNode.value1 = 0;
            newTreeNode.value2 = root.val;
            return newTreeNode;
        }
        NewTreeNode left = new NewTreeNode();
        NewTreeNode right = new NewTreeNode();
        if (root.left != null) {
            left = dfs(root.left);
        }
        if (root.right != null) {
            right = dfs(root.right);
        }
        newTreeNode.value1 = Math.max(left.value1 + right.value1, Math.max(left.value1 + right.value2, Math.max(left.value2 + right.value1, left.value2 + right.value2)));
        newTreeNode.value2 = left.value1 + right.value1 + root.val;
        return newTreeNode;
    }

    public static class NewTreeNode {
        public int value1;

        public int value2;

    }


}
