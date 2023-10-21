package com.zts.struct.queue;

/**
 * @Author zhangtusheng
 * @Date 2023 10 19 22 40
 * @describe：https://leetcode.cn/leetbook/read/illustration-of-algorithm/7fqor3/
 **/
public class CQueue {

    int[] queue;
    int start;
    int end;

    public CQueue() {
        queue = new int[10000];
        int start = 0;
        end = 0;
    }

    public void appendTail(int value) {
        queue[end++] = value;

    }

    public int deleteHead() {
        if (start == end) {
            return 0;
        }
        return queue[start++];
    }
}
