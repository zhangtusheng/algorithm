package com.zts.struct.queue;

import java.util.*;

/**
 * @Author zhangtusheng
 * @Date 2023 10 10 21 33
 * @describe：
 **/
class MinStack {

    Stack<Integer> stack ;
    PriorityQueue<Integer> queue;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        queue.offer(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        queue.remove(pop);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}