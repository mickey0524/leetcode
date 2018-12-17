// https://leetcode.com/problems/check-completeness-of-a-binary-tree/
//
// algorithms
// Medium (40.82%)
// Total Accepted:    2,738
// Total Submissions: 6,707
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
func isCompleteTree(root *TreeNode) bool {
	if root == nil {
		return true
	}

	treeArr := []*TreeNode{root}
	meetNil := false

	for len(treeArr) != 0 {
		node := treeArr[0]
		treeArr = treeArr[1:]

		if meetNil {
			if node.Left != nil || node.Right != nil {
				return false
			}
		} else if node.Left == nil || node.Right == nil {
			if node.Left == nil && node.Right != nil {
				return false
			} else if node.Left != nil && node.Right == nil {
				treeArr = append(treeArr, node.Left)
			}
			meetNil = true
		} else {
			treeArr = append(treeArr, node.Left, node.Right)
		}
	}

	return true
}
