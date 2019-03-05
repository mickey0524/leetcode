// https://leetcode.com/problems/diameter-of-binary-tree/
//
// algorithms
// Medium (46.23%)
// Total Accepted:    113,119
// Total Submissions: 244,707
// beats 100.0% of golang submissions

package leetcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var res int

func diameterOfBinaryTree(root *TreeNode) int {
	if root == nil {
		return 0
	}

	res = 0

	recursive(root)

	return res
}

func recursive(node *TreeNode) int {
	if node == nil {
		return 0
	}

	l, r := recursive(node.Left), recursive(node.Right)
	res = max(res, l+r)

	return max(l, r) + 1
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
