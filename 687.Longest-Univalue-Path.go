// https://leetcode.com/problems/longest-univalue-path/
// algorithms
// Easy (33.36%)
// Total Accepted:    51,984
// Total Submissions: 155,850
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

func longestUnivaluePath(root *TreeNode) int {
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

	if node.Left != nil && node.Val == node.Left.Val {
		l++
	} else {
		l = 0
	}
	if node.Right != nil && node.Val == node.Right.Val {
		r++
	} else {
		r = 0
	}

	res = max(res, l+r)

	return max(l, r)
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}
