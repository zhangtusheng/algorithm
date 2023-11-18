package com.zts.struct;

import java.util.Arrays;

/**
 * @author zts
 * @date 2023/10/30 15:55
 * @Description: 并查集
 */
public class UnionFind {

	int[] parents;

	int[] sizes;


	public UnionFind(int n) {
		parents = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		sizes = new int[n];
		Arrays.fill(sizes, 1);
	}

	public int find(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			parents[x] = find(parents[x]);
			return parents[x];
		}
	}


	public void union(int x, int y) {
		int rx = find(x), ry = find(y);
		if (rx != ry) {
			if (sizes[rx] > sizes[ry]) {
				parents[ry] = rx;
				sizes[rx] += sizes[ry];
			} else {
				parents[rx] = ry;
				sizes[ry] += sizes[rx];
			}
		}
	}

	public int getSize(int x) {
		return sizes[x];
	}
}
