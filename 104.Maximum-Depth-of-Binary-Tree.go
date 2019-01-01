// https://leetcode.com/problems/maximum-depth-of-binary-tree/
//
// algorithms
// Easy (58.19%)
// Total Accepted:    422,775
// Total Submissions: 726,507

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var res int

func maxDepth(root *TreeNode) int {
	res = -1

	resursive(root, 0)

	return res
}

func resursive(root *TreeNode, height int) {
	if root == nil {
		res = max(res, height)
		return
	}
	resursive(root.Left, height+1)
	resursive(root.Right, height+1)
}

func max(a, b int) int {
	if a >= b {
		return a
	}
	return b
}