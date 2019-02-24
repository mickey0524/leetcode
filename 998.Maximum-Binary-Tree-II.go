// https://leetcode.com/problems/maximum-binary-tree-ii/
//
// algorithms
// Medium (62.01%)
// Total Accepted:    2,381
// Total Submissions: 3,840
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
func insertIntoMaxTree(root *TreeNode, val int) *TreeNode {
	if root == nil {
		return &TreeNode{
			Val: val,
		}
	}

	if val > root.Val {
		node := &TreeNode{
			Val:  val,
			Left: root,
		}
		return node
	}

	root.Right = insertIntoMaxTree(root.Right, val)

	return root
}
