// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
//
// algorithms
// Medium (39.54%)
// Total Accepted:    200.6K
// Total Submissions: 507.3K

package leetcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func flatten(root *TreeNode) {
	resursive(root)
	return
}

func resursive(root *TreeNode) *TreeNode {
	if root == nil {
		return root
	}

	var left, right *TreeNode

	if root.Left != nil {
		left = resursive(root.Left)
	}
	if root.Right != nil {
		right = resursive(root.Right)
	}

	tmp := root

	if left != nil {
		tmp.Right = left
		tmp.Left = nil
		for left.Right != nil {
			left = left.Right
		}
		tmp = left
	}

	if right != nil {
		tmp.Right = right
	}

	return root
}
