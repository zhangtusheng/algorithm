package com.zts.week;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangtusheng
 * @Date 2023 09 24 16 47
 * @describe：https://leetcode.cn/contest/weekly-contest-364/
 **/
public class Week364 {

    public static void main(String[] args) {
        Week364 week364 = new Week364();
        //System.out.println(week364.maximumOddBinaryNumber("0101"));
        //System.out.println(week364.countPaths(6, new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}}));
        //System.out.println(week364.maximumSumOfHeights(List.of(1,12,19)));
        System.out.println(week364.maximumSumOfHeights(List.of(1,5,2,5,6,4,6,3,4,5)));
    }


    /**
     * https://leetcode.cn/problems/beautiful-towers-ii/
     * @param maxHeights
     * @return
     */
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        if (maxHeights.size() == 2) {
            return maxHeights.get(0) + maxHeights.get(1);
        }
        long left = 0;
        List<Integer> currentHeight = new ArrayList<>(maxHeights);
        List<Long> sumHeight = new ArrayList<>(maxHeights.size());
        for (Integer maxHeight : maxHeights) {
            sumHeight.add(Long.valueOf(maxHeight));
        }
        long right = getRight(0, maxHeights, currentHeight);
        getRightSum(sumHeight, currentHeight, 0);
        long maxValue = right + maxHeights.get(0);
        for (int i = 1; i < maxHeights.size(); i++) {
            Integer current = maxHeights.get(i);
            // 无非就两种情况，如果当前节点比前节点大的话，那么左边的就不用更新，直接加入当前值就好了，如果小于当前节点的话，就要更新左边的所有节点。
            Integer leftCurrent = currentHeight.get(i - 1);
            if (i<maxHeights.size()-1) {
                if (current == currentHeight.get(i)) {
                    right -= current;
                } else {
                    right = getRight(i, maxHeights, currentHeight, sumHeight);
                    getRightSum(sumHeight, currentHeight, i);
                }
            } else {
                right = 0;
            }
            if (leftCurrent > current) {
                left = getLeft(i, maxHeights, currentHeight);
            } else {
                left += leftCurrent;
            }
            currentHeight.set(i, current);
            maxValue = Math.max(maxValue, left + right + current);
        }
        return maxValue;
    }

    private void getRightSum(List<Long> sumHeight, List<Integer> currentHeight, int index) {
        long ans = 0L;
        for(int i = index;i<currentHeight.size();i++) {
            ans += currentHeight.get(i);
        }
        sumHeight.set(index, ans);
        for (int i = 1; i < currentHeight.size(); i++) {
            ans -= currentHeight.get(i-1);
            sumHeight.set(i, ans);
        }
    }


    private long getLeft(int index, List<Integer> maxHeights, List<Integer> currentList) {
        long left = 0;
        Integer current = maxHeights.get(index);
        for (int i = index - 1; i >= 0; i--) {
            Integer i1 = maxHeights.get(i);
            if (i1 > current) {
                left += current;
            } else {
                current = i1;
                left += i1;
            }
            currentList.set(i, current);
        }
        return left;
    }

    private long getRight(int index, List<Integer> maxHeights, List<Integer> currentList, List<Long> sumHeight) {
        long right = 0;
        Integer current = maxHeights.get(index);
        Long sum = sumHeight.get(index);
        for (int i = index + 1; i < maxHeights.size(); i++) {
            Integer i1 = maxHeights.get(i);
            if (i1 > current) {
                sum -= i1 - current;
                right += current;
                currentList.set(i, current);
                sumHeight.set(i, sum);
            } else {
                return sumHeight.get(index+1);
            }

        }
        return right;
    }

    private long getRight(int index, List<Integer> maxHeights, List<Integer> currentList) {
        long right = 0;
        Integer current = maxHeights.get(index);
        for (int i = index + 1; i < maxHeights.size(); i++) {
            Integer i1 = maxHeights.get(i);
            if (i1 > current) {
                right += current;

            } else {
                current = i1;
                right += i1;
            }
            currentList.set(i, current);
        }
        return right;
    }

    /**
     * https://leetcode.cn/problems/count-valid-paths-in-a-tree/
     * @param n
     * @param edges
     * @return
     */
    public long countPaths(int n, int[][] edges) {
        long ans = 0;
        boolean[][] visited = new boolean[n][n];
        boolean[] primeNumber = new boolean[n + 1];
        primeNumber[1] = false;
        primeNumber[0] = false;
        for (int i = 2; i < n+1; i++) {
            primeNumber[i] = prime(i);
        }
        for (int i = 0; i < edges.length; i++) {
            int i1 = edges[i][0];
            int i2 = edges[i][1];
            if (!visited[i1][i2] && !visited[i2][i1]) {
                visited[i1][i2] = true;
                if ((!primeNumber[i1] && primeNumber[i2]) || (primeNumber[i1] && !primeNumber[i2])) {
                    ans++;
                }
            }

        }
        return ans;

    }

    private boolean prime(int n) {
        for(int i = 2;i<=Math.sqrt(n);i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * https://leetcode.cn/problems/maximum-odd-binary-number/
     * @param s
     * @return
     */
    public String maximumOddBinaryNumber(String s) {
        int one = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '1') {
                one++;
            }
        }
        StringBuilder result = new StringBuilder("");
        if (one <= 1) {
            for(int i = 0;i<s.length() - 1;i++) {
                result.append("0");
            }
            if (one == 1) {
                result.append("1");
            } else {
                result.append("0");
            }
            return result.toString();
        } else {
            int length = one-1;
            for (int i = 0; i < length; i++) {
                result.append("1");
            }
            int zero = s.length() - 1- length;
            for (int i = 0; i < zero; i++) {
                result.append("0");
            }
            result.append("1");
        }
        return result.toString()
                ;

    }
}
