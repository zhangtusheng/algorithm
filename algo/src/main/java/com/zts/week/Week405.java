package com.zts.week;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangtusheng
 * @Date 2024 07 07 10 42
 * @describe：https://leetcode.cn/contest/weekly-contest-405
 **/
public class Week405 {

    public static void main(String[] args) {
        Week405 week405 = new Week405();
//        System.out.println(week405.getEncryptedString("dart", 3));
        System.out.println(JSON.toJSONString(week405.validStrings(3)));
    }


    public String getEncryptedString(String s, int k) {
        String result = "";
        char[] charArray = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < charArray.length; i++) {
            int c = (i + k) % n;
            result = result + (charArray[c]);
        }
        return result;
    }


    public List<String> validStrings(int n) {
        ans = new ArrayList<>();
        dfs(0, "", n);
        return ans;
    }

    private List<String> ans;

    private void dfs(int length, String s, int targetLength) {
        if (s.length() == targetLength) {
            ans.add(new String(s));
            return;
        }
        dfs(length + 1, s + "1", targetLength);
        s = s.substring(0, length);
        if (length == 0 || s.charAt(length - 1) == '1') {
            dfs(length + 1, s + "0", targetLength);
        }
    }


    public int numberOfSubmatrices(char[][] grid) {
        int ans = 0;
        int[][] colCnt = new int[grid[0].length][2];
        for (char[] row : grid) {
            int s0 = 0, s1 = 0;
            for (int i = 0; i < row.length; i++) {
                if (row[i] != '.') {
                    colCnt[i][row[i] & 1 ]++;
                }
                s0 += colCnt[i][0];
                s1 += colCnt[i][1];
                if (s0 > 0 && s0 == s1) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
