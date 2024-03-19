package com.zts.string;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhangtusheng
 * @Date 2023 11 15 23 40
 * @describe：
 **/
public class MathString {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(buildPMT("abababab")));
    }

    private static int[] buildPMT(String pattern) {
        int m = pattern.length();
        int[] pmt = new int[m];
        int len = 0;
        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                pmt[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = pmt[len - 1];
                } else {
                    pmt[i] = 0;
                    i++;
                }
            }
        }
        return pmt;
    }


}
