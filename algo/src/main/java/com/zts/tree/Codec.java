package com.zts.tree;

import com.zts.model.TreeNode;

/**
 * @author zts
 * @date 2023/9/4 12:56
 * @Description
 */
public class Codec {
	// Encodes a tree to a single string.

	public String serialize(TreeNode root) {
		return preorderTraversal(root).toString();
	}

	StringBuilder preorderTraversal(TreeNode node){
		StringBuilder sb = new StringBuilder();
		if(node==null){
			sb.append("n ");
			return sb;
		}
		sb.append(node.val);
		sb.append(" ");
		sb.append(preorderTraversal(node.left));
		sb.append(preorderTraversal(node.right));
		return sb;
	}

	// Decodes your encoded data to tree.
	int i=0;
	String[] ss;
	public TreeNode deserialize(String data) {
		ss = data.split(" ");
		return preorderBuild();
	}
	TreeNode preorderBuild(){
		if(i>=ss.length||"n".equals(ss[i]))return null;
		TreeNode node = new TreeNode(Integer.parseInt(ss[i]));
		i++;
		node.left=preorderBuild();
		i++;
		node.right=preorderBuild();
		return node;
	}
}
