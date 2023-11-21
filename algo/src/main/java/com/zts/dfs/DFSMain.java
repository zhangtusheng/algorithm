package com.zts.dfs;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zts
 * @date 2023/8/19 16:39
 * @Description
 */
public class DFSMain {

	public static void main(String[] args) {
		DFSMain dfsMain = new DFSMain();
		System.out.println(JSON.toJSONString(dfsMain.combinationSum(new int[]{2, 3, 6, 7}, 7)));
	}


	/**
	 * https://leetcode.cn/problems/rotate-image/
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int tmp  = matrix[i][j];
				matrix[i][j] = matrix[n - i - 1][j];
				matrix[n - i - 1][j] = tmp;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}

	}


	/**
	 * https://leetcode.cn/problems/combination-sum/
	 * @param candidates
	 * @param target
	 * @return
	 */
	List<List<Integer>> result = new ArrayList<>();
	Map<String, String> map = new HashMap<>();
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		map = new HashMap<>();
		result = new ArrayList<>();
		Arrays.sort(candidates);
		Map<Integer, Integer> map = new HashMap<>();
		for (int candidate : candidates) {
			map.put(candidate, candidate);
		}
		dfs(candidates, target, 0, new ArrayList<Integer>());
		return result;
	}

	private void dfs(int[] candidates, int target, int sum, List<Integer> currentValue) {
		if (sum == target) {
			StringBuilder string = new StringBuilder();
			ArrayList<Integer> integers = (ArrayList<Integer>) new ArrayList<>(currentValue).stream().sorted().collect(Collectors.toList());
			for (int i = 0; i < integers.size(); i++) {
				if (i == 0) {
					string.append(integers.get(i));
				} else {
					string.append(","+integers.get(i));
				}
			}
			String string1 = string.toString();
			if (map.get(string1) == null) {
				result.add(integers);
				map.put(string1, string1);
			}
			//currentValue.remove(currentValue.size() - 1);
		}
		if (sum > target) {
			 //currentValue.remove(currentValue.size() - 1);
			 return ;
		}
		for (int i = 0; i < candidates.length; i++) {
			currentValue.add(candidates[i]);
			int length = currentValue.size();
			dfs(candidates, target, sum + candidates[i], currentValue);
			currentValue.remove(length -1);
		}
	}




}
