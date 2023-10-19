package com.zts.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zts
 * @date 2023/8/19 16:39
 * @Description
 */
public class DFSMain {

	public static void main(String[] args) {
		DFSMain dfsMain = new DFSMain();

	}


	/**
	 * https://leetcode.cn/problems/combination-sum/
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		Map<Integer, Integer> map = new HashMap<>();
		for (int candidate : candidates) {
			map.put(candidate, candidate);
		}
		dfs(candidates, target, result);

	}


}
