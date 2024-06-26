package com.zts.everyday;

import java.util.*;

import com.zts.model.TreeNode;

/**
 * @Author zhangtusheng
 * @Date 2024 06 01 11 25
 * @describe：
 **/
public class Main202406 {

    public static void main(String[] args) {
        Main202406 main202406 = new Main202406();
//        System.out.println(main202406.distributeCandies(5, 3));
//        System.out.println(main202406.distributeCandies(3, 3));
//        main202406.test();

//        System.out.println(main202406.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
//        System.out.println(main202406.distributeCandies(new int[]{6, 6, 6, 6}));

//        System.out.println(main202406.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(main202406.minimumSteps("110"));
//        System.out.println(main202406.minimumSteps("001"));
//        System.out.println(main202406.minimumSteps("101"));
//        System.out.println(main202406.maxOperations1(new int[]{3, 2, 1, 2, 3, 4}));
//        System.out.println(main202406.subarraySum(new int[]{1, 1, 1}, 2));
//        System.out.println(main202406.subarraySum(new int[]{1, 2, 3}, 3));
//        System.out.println(main202406.subarraySum(new int[]{-1, -1, 1}, 0));
//        System.out.println(main202406.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
//        System.out.println(main202406.checkSubarraySum(new int[]{23,2,6,4,7}, 13));
//        System.out.println(main202406.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
//        System.out.println(main202406.checkSubarraySum(new int[]{5, 0, 0, 0}, 3));
//        System.out.println(main202406.checkSubarraySum(new int[]{1, 0}, 2));
        System.out.println(main202406.numOfSubarrays(new int[]{1, 3, 5}));
        System.out.println(main202406.numOfSubarrays(new int[]{2, 4, 6}));
    }

    /**
     * https://leetcode.cn/problems/number-of-sub-arrays-with-odd-sum/
     * @param arr
     * @return
     */
    public int numOfSubarrays(int[] arr) {
        int[] s = new int[arr.length + 1];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + arr[i];
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            // 判断当前是奇还是偶数
            if (s[i] % 2 ==1) {
                Integer orDefault = map.getOrDefault(0, 0);
                if (orDefault != 0) {
                    // 当前也是合法的。
                    ans += orDefault + 1;
                } else {
                    ans++;
                }
            } else {
                Integer orDefault = map.getOrDefault(1, 0);
                if (orDefault != 0) {
                    ans += orDefault;
                }

            }
            ans = ans % (10^7 + 9);
            map.merge(s[i] % 2, 1, Integer::sum);
        }
        return ans;
    }


    /**
     * https://leetcode.cn/problems/continuous-subarray-sum/
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] s = new int[nums.length + 1];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        boolean flag = false;
        for (int i = 1;i<=n;i++) {
            // 只要前面出现过这种操作，后续就不需要处理了。
            int t = s[i] % k;
            Integer orDefault = map.get(t);
            if (orDefault == null && s[i] % k == 0 && i >1) {
                flag = true;
                break;
            }
            if (orDefault != null) {
                flag =true;
                break;
            }
            map.put(t, i);
        }
        return flag;
    }

    /**
     * https://leetcode.cn/problems/subarray-sum-equals-k/description/
     * @param nums: 将两个变量的变成一个变量来进行计算，然后统计他们的和就好了
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
        }

        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>(n + 1); // 设置容量可以快 2ms
        for (int sj : s) {
            ans += cnt.getOrDefault(sj - k, 0);
            cnt.merge(sj, 1, Integer::sum);
        }
        return ans;
    }



    /**
     * https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-ii/?envType=daily-question&envId=2024-06-08
     * @param nums
     * @return
     */
    Integer maxOperationNums = 0;
    public int maxOperations1(int[] nums) {
        maxOperationNums = 0;
        int length = nums.length;
        dfs(nums, 0, 0, nums.length -1, nums[0] + nums[1]);
        dfs(nums, 0, 0, nums.length - 1, nums[length -1] + nums[length - 2]);
        dfs(nums, 0, 0, nums.length - 1, nums[length -1] + nums[0]);
        return maxOperationNums;
    }

    private void dfs(int[] nums, int operationNums, int start, int end, int target) {
        if (start >= end) {
            maxOperationNums = Math.max(maxOperationNums, operationNums);
            return;
        }

        // 前面两个
        if (start + 1 <= end && nums[start] + nums[start + 1] == target) {
            dfs(nums, operationNums + 1, start + 2, end, target);
        }
        // 后面两个
        if (end - 1 >= start && nums[end- 1] + nums[end] == target) {
            dfs(nums, operationNums + 1, start, end - 2, target);
        }
        // 一个前一个后
        if (start != end && nums[start] + nums[end] == target) {
            dfs(nums, operationNums + 1, start + 1, end - 1, target);
        }
        maxOperationNums = Math.max(maxOperationNums, operationNums);
    }


    /**
     * https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i/?envType=daily-question&envId=2024-06-07
     * @param nums
     * @return
     */
    public int maxOperations(int[] nums) {
        int start = 0;
        int sum = nums[0] + nums[1];
        int ans = 0;
        while (start < nums.length && start + 1 < nums.length) {
            if (nums[start] + nums[start + 1] == sum) {
                start += 2;
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }


    /**
     * https://leetcode.cn/problems/separate-black-and-white-balls/?envType=daily-question&envId=Invalid%20Date
     * @param s
     * @return
     */
    public long minimumSteps(String s) {
        // 标记黑球的位置。
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                queue.offer(i);
            }
        }

        long ans = 0L;
        //
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == '1') {
                if (!queue.isEmpty() && queue.peek() > i) {
                    ans += Math.abs(i - queue.poll());
                    queue.offer(i);
                }
            }
        }
        return ans;
    }

    /**
     * https://leetcode.cn/problems/longest-common-prefix/
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder(strs[0]);
        int n = strs.length;
        int i = 1;
        while (i < n) {
            StringBuilder sb1 = new StringBuilder("");
            char[] charArray = sb.toString().toCharArray();
            char[] charArray1 = strs[i].toCharArray();
            int minLength = Math.min(sb.length(), strs[i].length());
            for (int j = 0; j < minLength; j++) {
                if (charArray[j] == charArray1[j]) {
                    sb1.append(charArray[j]);
                } else {
                    break;
                }
            }
            sb = sb1;
            if (sb.length() == 0) {
                break;
            }
            i++;
        }
        return sb.toString();
    }

    /**
     * https://leetcode.cn/problems/distribute-candies-to-people/?envType=daily-question&envId=2024-06-03
     * @param candies
     * @param num_people
     * @return
     */
    public int[] distributeCandies1(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        while (candies > 0) {
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= i + 1;
            i++;
        }
        return ans;
    }


    /**
     * https://leetcode.cn/problems/distribute-candies/?envType=daily-question&envId=2024-06-02
     * @param candyType
     * @return
     */
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int m = n / 2;
        int[] count = new int[200001];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (count[candyType[i] + 100000] == 0) {
                ans++;
            }
            count[candyType[i] + 100000]++;
        }
        return Math.min(ans, m);
    }

    private void test() {
        // 计算1的个数。
        System.out.println(Integer.bitCount(7));
        System.out.println(32 - Integer.numberOfLeadingZeros(3));
        System.out.println(Integer.numberOfLeadingZeros(3));
        System.out.println(Integer.numberOfTrailingZeros(3));
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
