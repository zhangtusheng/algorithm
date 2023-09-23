package com.zts.tree;

import java.util.ArrayList;
import java.util.List;

import com.zts.model.TreeNode;

/**
 * @author zts
 * @date 2023/9/4 12:56
 * @Description
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder result = new StringBuilder();
		List<TreeNode> list = new ArrayList<>();
		dfs1(root, list);
		for (int i = 0; i < list.size(); i++) {
			TreeNode treeNode = list.get(i);

		}
		return null;

	}

	private void dfs1(TreeNode root, List<TreeNode> list) {
		if (root == null) {
			list.add(null);
			return;
		}
		list.add(root);
		dfs1(root.left, list);
		dfs1(root.right, list);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return null;
	}
}
