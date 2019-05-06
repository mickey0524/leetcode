// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
//
// algorithms
// Medium (83.53%)
// Total Accepted:    3,211
// Total Submissions: 3,844
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

var curSum int

func bstToGst(root *TreeNode) *TreeNode {
	if root == nil {
		return root
	}

	curSum = 0

	recursive(root)

	return root
}

func recursive(root *TreeNode) {
	if root == nil {
		return
	}

	recursive(root.Right)

	tmp := root.Val
	root.Val += curSum
	curSum += tmp

	recursive(root.Left)
}
