package com.zts.struct;

import com.alibaba.fastjson.JSON;
import com.zts.struct.queue.CQueue;

import java.util.*;

/**
 * @Author zhangtusheng
 * @Date 2023 10 19 22 53
 * @describe：
 **/
public class Main {

    public static void main(String[] args) {
//        CQueue myQueue = new CQueue();
//        myQueue.appendTail(1); // queue is: [1]
//        myQueue.appendTail(2); // queue is: [1, 2] (leftmost is front of the queue)
//        System.out.println(myQueue.deleteHead());

        Main main = new Main();
        //System.out.println(main.validateBookSequences(new int[]{6, 7, 8, 9, 10, 11}, new int[]{9, 11, 10, 8, 7, 6}));
        //System.out.println(main.validateBookSequences(new int[]{6, 7, 8, 9, 10, 11}, new int[]{11,9,8,10,6,7}));
        //System.out.println(JSON.toJSONString(main.maxAltitude(new int[]{14, 2, 27, -5, 28, 13, 39}, 3)));
        MedianFinder medianFinder = new MedianFinder();
        //[1],[2],[],[3],[]]
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }




    /**
     *
     * @param heights
     * @param limit
     * @return
     */
    public int[] maxAltitude(int[] heights, int limit) {
        if (heights.length == 0) return new int[0];
        Queue<Integer> stack = new PriorityQueue<>((a,b) -> b-a);
        stack.offer(heights[0]);
        List<Integer> result = new ArrayList<>();
        if (stack.size() == limit) {
            result.add(stack.peek());
        }
        for(int i = 1;i<heights.length;i++) {
            stack.offer(heights[i]);
            if (stack.size() > limit) {
                stack.remove(heights[i-limit]);
            }
            if (stack.size() == limit) {
                result.add(stack.peek());
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }


    /**
     *
     * @param putIn
     * @param takeOut
     * @return
     */
    public boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int i = 0;
        for(;i<takeOut.length;i++) {
            int value = takeOut[i];
            if (!stack.isEmpty() && stack.peek() == value) {
                stack.pop();
                continue;
            }
            while (index < putIn.length && putIn[index] != value) {
                stack.push(putIn[index]);
                index++;
            }
            index++;
        }
        while (!stack.isEmpty() && i < takeOut.length) {
            if (stack.peek() == takeOut[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
