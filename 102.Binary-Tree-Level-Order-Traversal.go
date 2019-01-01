// https://leetcode.com/problems/binary-tree-level-order-traversal/
//
// algorithms
// Medium (47.64%)
// Total Accepted:    311,896
// Total Submissions: 677,770

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
	var res [][]int
	if root == nil {
		return res
	}

	nodes := []*TreeNode{root, nil}
	level := []int{}
	for {
		cntNode := nodes[0]
		nodes = nodes[1:]
		if cntNode == nil {
			res = append(res, level)
			level = []int{}
			if len(nodes) == 0 {
				break
			}
			nodes = append(nodes, nil)
		} else {
			level = append(level, cntNode.Val)
			if cntNode.Left != nil {
				nodes = append(nodes, cntNode.Left)
			}
			if cntNode.Right != nil {
				nodes = append(nodes, cntNode.Right)
			}
		}
	}

	return res
}
