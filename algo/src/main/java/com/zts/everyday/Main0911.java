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
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(4);
//        root.right = new TreeNode(5);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        root.right.right = new TreeNode(1);
//        System.out.println(main0911.rob(root));

       // System.out.println(main0911.minCapability(new int[]{2,3,5,9}, 2));
        //System.out.println(main0911.minCount(new int[]{2, 3, 10}));
        System.out.println(main0911.distMoney(24, 2));
    }


    /**
     * https://leetcode.cn/problems/distribute-money-to-maximum-children/?envType=daily-question&envId=2023-09-23
     * @param money
     * @param children
     * @return
     */
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        if (money < 8 + children - 1) {
            return 0;
        }

        // 贪心算法。默认都取8先，如果最后的值为4的话，
        int t = money % 8;
        int n = money / 8;
        // 分情况讨论
        if (n == children && t == 0) {
            return n;
        } else if (n < children) {
            if (n + 1 == children && t == 4) {
                return n-1;
            } else {
                int i = 1;
                if (t >= (children - n)) {
                    return n;
                }
                n--;
                while ( i * 8 + n + t < children) {
                    i++;
                    n--;
                }
                return n;
            }
        } else {
            return children - 1;
        }
    }

    /**
     * https://leetcode.cn/problems/na-ying-bi/?envType=daily-question&envId=2023-09-20
     * @param coins
     * @return
     */
    public int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            if (coin % 2 != 0) {
                ans = ans + 1 + coin /2;
            } else {
                ans = ans + coin / 2;
            }
        }
        return ans;
    }

    /**
     * https://leetcode.cn/problems/house-robber-iv/?envType=daily-question&envId=2023-09-19
     * @param nums
     * @param k
     * @return
     */
    public int minCapability(int[] nums, int k) {
        int lower = Arrays.stream(nums).min().getAsInt();
        int upper = Arrays.stream(nums).max().getAsInt();
        while (lower <= upper) {
            int middle = (lower + upper) / 2;
            int count = 0;
            boolean visited = false;
            for (int x : nums) {
                if (x <= middle && !visited) {
                    count++;
                    visited = true;
                } else {
                    visited = false;
                }
            }
            if (count >= k) {
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return lower;
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
