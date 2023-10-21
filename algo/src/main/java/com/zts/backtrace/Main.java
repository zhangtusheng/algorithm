package com.zts.backtrace;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhangtusheng
 * @Date 2023 10 20 17 13
 * @describe：
 **/
public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(JSON.toJSONString(main.goodsOrder("agew")));

    }


    /**
     * https://leetcode.cn/leetbook/read/illustration-of-algorithm/5dfv5h/
     * @param goods
     * @return
     */
    List<String> result;
    public String[] goodsOrder(String goods) {
        boolean[] visited = new boolean[goods.length()];
        result = new ArrayList<>();
        char[] target = new char[goods.length()];
        dfs(visited, goods.toCharArray(), target, 0);
        result = result.stream().distinct().collect(Collectors.toList());
        String[] strings = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            strings[i] = result.get(i);
        }
        return strings;
    }


    private void dfs(boolean[] visited, char[] goods, char[] target, int index) {
        if (index == goods.length) {
            String s = new String(target);
            result.add(s);
            return ;
        }
        for (int i = 0; i < goods.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                target[index] = goods[i];
                dfs(visited, goods, target, index +1);
                visited[i] = false;
            }
        }
    }

}
