// https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
//
// algorithms
// Medium (39.29%)
// Total Accepted:    2,099
// Total Submissions: 5,342
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
var res []int
var resursiveBreak bool
var idx int

func flipMatchVoyage(root *TreeNode, voyage []int) []int {
	res = []int{}
	resursiveBreak = false
	idx = 0

	resursive(root, voyage)

	if resursiveBreak {
		return []int{-1}
	}

	return res
}

func resursive(node *TreeNode, voyage []int) {
	if resursiveBreak {
		return
	}
	if idx == len(voyage) {
		return
	}
	if node.Val != voyage[idx] {
		resursiveBreak = true
		return
	}

	if node.Left == nil && node.Right == nil {
		return
	} else if node.Left == nil {
		idx++
		resursive(node.Right, voyage)
	} else if node.Right == nil {
		idx++
		resursive(node.Left, voyage)
	} else {
		if node.Left.Val != voyage[idx+1] {
			node.Left, node.Right = node.Right, node.Left
			res = append(res, node.Val)
		}
		idx++
		resursive(node.Left, voyage)
		idx++
		resursive(node.Right, voyage)
	}
}
