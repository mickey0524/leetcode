// https://leetcode.com/problems/binary-tree-right-side-view/
//
// algorithms
// Medium (47.38%)
// Total Accepted:    160,814
// Total Submissions: 339,423
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
func rightSideView(root *TreeNode) []int {
	var res []int
	var rightSideVal int
	if root == nil {
		return res
	}

	nodeQueue := []*TreeNode{root, nil}

	for {
		node := nodeQueue[0]
		nodeQueue = nodeQueue[1:]

		if node == nil {
			res = append(res, rightSideVal)
			if len(nodeQueue) > 0 {
				nodeQueue = append(nodeQueue, nil)
			} else {
				break
			}
		} else {
			rightSideVal = node.Val
			if node.Left != nil {
				nodeQueue = append(nodeQueue, node.Left)
			}
			if node.Right != nil {
				nodeQueue = append(nodeQueue, node.Right)
			}
		}
	}

	return res
}
