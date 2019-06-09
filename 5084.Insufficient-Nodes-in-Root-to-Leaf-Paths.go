// https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
//
// algorithms
// Medium (15.95%)
// Total Accepted:    951
// Total Submissions: 5,962
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

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type treeNodeEntry struct {
	left bool
	node *TreeNode
}

var stack []treeNodeEntry

func sufficientSubset(root *TreeNode, limit int) *TreeNode {
	if root == nil {
		return nil
	}
	if root.Left == nil && root.Right == nil {
		if root.Val >= limit {
			return nil
		}
		return root
	}

	stack = []treeNodeEntry{}

	recursive(root, 0, limit)

	if root.Left == nil && root.Right == nil {
		return nil
	}
	return root
}

func recursive(node *TreeNode, sum, limit int) {
	if node.Left == nil && node.Right == nil {
		if sum+node.Val < limit {
			deleteNode()
		}
		return
	}

	if node.Left != nil {
		stack = append(stack, treeNodeEntry{
			left: true,
			node: node,
		})
		recursive(node.Left, sum+node.Val, limit)
		stack = stack[:len(stack)-1]
	}

	if node.Right != nil {
		stack = append(stack, treeNodeEntry{
			left: false,
			node: node,
		})
		recursive(node.Right, sum+node.Val, limit)
		stack = stack[:len(stack)-1]
	}

	if node.Left == nil && node.Right == nil {
		deleteNode()
	}
}

func deleteNode() {
	length := len(stack)
	if length == 0 {
		return
	}
	if stack[length-1].left {
		stack[length-1].node.Left = nil
	} else {
		stack[length-1].node.Right = nil
	}
}
