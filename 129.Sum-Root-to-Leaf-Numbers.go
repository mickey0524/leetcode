// https://leetcode.com/problems/sum-root-to-leaf-numbers/
//
// algorithms
// Medium (42.74%)
// Total Accepted:    188,055
// Total Submissions: 440,030
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

var res int

func sumNumbers(root *TreeNode) int {
	if root == nil {
		return 0
	}

	res = 0
	recursive(root, 0)

	return res
}

func recursive(root *TreeNode, curSum int) {
	sum := curSum*10 + root.Val
	if root.Left == nil && root.Right == nil {
		res += sum
		return
	}

	if root.Left != nil {
		recursive(root.Left, sum)
	}
	if root.Right != nil {
		recursive(root.Right, sum)
	}
}
