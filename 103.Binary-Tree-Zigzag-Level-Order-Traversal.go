// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
//
// algorithms
// Medium (38.95%)
// Total Accepted:    171.7k
// Total Submissions: 440.8k
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
func zigzagLevelOrder(root *TreeNode) [][]int {
	res := [][]int{}
	if root == nil {
		return res
	}

	queue := []interface{}{}
	queue = append(queue, []interface{}{root, '#'}...)
	left2right := true
	level := []int{}

	for {
		if queue[0] == '#' {
			left2right = !left2right
			res = append(res, level)
			if len(queue) == 1 {
				break
			}
			queue = append(queue, '#')
			level = []int{}
		} else {
			node := queue[0].(*TreeNode)
			if left2right {
				level = append(level, node.Val)
			} else {
				level = append([]int{node.Val}, level...)
			}
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		queue = queue[1:]
	}

	return res
}
