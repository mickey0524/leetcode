// https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
//
// algorithms
// Easy (66.85%)
// Total Accepted:    12.1k
// Total Submissions: 18.1k
// beats 89.06% of golang submissions

package leetcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var done = new(bool)
var lastNode = new(TreeNode)

func insertIntoBST(root *TreeNode, val int) *TreeNode {
	*done = false
	if root == nil {
		return &TreeNode{
			Val: val,
		}
	}

	resursive(root, val)

	if !*done {
		lastNode.Right = &TreeNode{
			Val: val,
		}
	}

	return root
}

func resursive(node *TreeNode, val int) {
	if *done || node == nil {
		return
	}
	lastNode = node
	resursive(node.Left, val)
	if *done {
		return
	}
	if val < node.Val {
		if node.Left == nil {
			node.Left = &TreeNode{
				Val: val,
			}
		} else {
			lastNode.Right = &TreeNode{
				Val: val,
			}
		}
		*done = true
		return
	}
	lastNode = node
	resursive(node.Right, val)
}
