// https://leetcode.com/problems/distribute-coins-in-binary-tree/
//
// algorithms
// Medium (64.98%)
// Total Accepted:    2,221
// Total Submissions: 3,418
// beats 100.0% of golang submissions

package leetcode

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var res int

func distributeCoins(root *TreeNode) int {
	if root == nil {
		return 0
	}
	res = 0

	resursive(root)

	return res
}

func resursive(node *TreeNode) int {
	if node.Left == nil && node.Right == nil {
		res += abs(node.Val - 1)
		return node.Val - 1
	}
	tmp := node.Val - 1
	if node.Left != nil {
		tmp += resursive(node.Left)
	}
	if node.Right != nil {
		tmp += resursive(node.Right)
	}
	res += abs(tmp)
	return tmp
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}
