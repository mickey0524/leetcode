// https://leetcode.com/problems/validate-binary-search-tree/description/
//
// algorithms
// Medium (23.75%)
// Total Accepted:    308.7K
// Total Submissions: 1.3M
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
var lastVal int
var res bool
var isFirstEleFound bool

func isValidBST(root *TreeNode) bool {
	if root == nil || (root.Left == nil && root.Right == nil) {
		return true
	}

	res = true
	isFirstEleFound = false

	resursive(root)

	return res
}

func resursive(node *TreeNode) {
	if !res || node == nil {
		return
	}

	resursive(node.Left)

	if !isFirstEleFound {
		lastVal = node.Val
		isFirstEleFound = true
	} else if node.Val > lastVal {
		lastVal = node.Val
	} else {
		res = false
		return
	}

	resursive(node.Right)
}
