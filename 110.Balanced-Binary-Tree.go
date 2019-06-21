// https://leetcode.com/problems/balanced-binary-tree/
//
// algorithms
// Easy (41.13%)
// Total Accepted:    326,769
// Total Submissions: 794,518
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
var res bool

func isBalanced(root *TreeNode) bool {
	if root == nil {
		return true
	}

	res = true

	recursive(root)

	return res
}

func recursive(root *TreeNode) int {
	if root == nil || !res {
		return 0
	}

	left := recursive(root.Left)
	right := recursive(root.Right)

	if left > right+1 || left < right-1 {
		res = false
	}

	return max(left, right) + 1
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}
