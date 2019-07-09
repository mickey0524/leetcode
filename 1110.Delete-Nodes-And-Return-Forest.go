// https://leetcode.com/problems/shortest-path-in-binary-matrix/
//
// algorithms
// Medium (60.0%)
// Total Accepted:    3,575
// Total Submissions: 5,958
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
var res []*TreeNode

func delNodes(root *TreeNode, to_delete []int) []*TreeNode {
	res = []*TreeNode{}
	if root == nil {
		return res
	}

	hashMap := make(map[int]bool)
	for _, v := range to_delete {
		hashMap[v] = true
	}

	recursive(root, hashMap, nil)

	return res
}

func recursive(node *TreeNode, hashMap map[int]bool, parent *TreeNode) {
	if node == nil {
		return
	}

	var parentNode *TreeNode
	if !hashMap[node.Val] {
		if parent == nil {
			res = append(res, node)
		}
		parentNode = node
	} else {
		if parent != nil {
			if parent.Left == node {
				parent.Left = nil
			} else {
				parent.Right = nil
			}
		}
	}

	recursive(node.Left, hashMap, parentNode)
	recursive(node.Right, hashMap, parentNode)
}
