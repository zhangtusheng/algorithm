package com.zts.everyday;

import com.zts.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangtusheng
 * @Date 2024 06 01 11 25
 * @describe：
 **/
public class Main202406 {

    public static void main(String[] args) {
        Main202406 main202406 = new Main202406();
        System.out.println(main202406.distributeCandies(5, 3));
        System.out.println(main202406.distributeCandies(3, 3));
    }

    /**
     * https://leetcode.cn/problems/path-sum-ii/
     * @param root
     * @param targetSum
     * @return
     */
    List<List<Integer>> result = null;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        }
        dfs(root.left, targetSum, path);
        dfs(root.right, targetSum, path);
        path.remove(path.size() - 1);
    }


    /**
     * https://leetcode.cn/problems/distribute-candies-among-children-i/?envType=daily-question&envId=2024-06-01
     * @param n
     * @param limit
     * @return
     */
    int ans = 0;
    public int distributeCandies(int n, int limit) {
        ans = 0;
        dfs(limit, 0, n);
        return ans;
    }

    private void dfs(int limit, int count, int sum) {
        if (count == 3 && sum == 0) {
            ans++;
            return;
        } else if (count >= 3) {
            return;
        }

        for (int i = 0; i <= limit && i <= sum; i++) {
            dfs(limit, count+1, sum - i);
        }
    }


}