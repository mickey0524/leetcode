// https://leetcode.com/problems/binary-tree-inorder-traversal/
//
// algorithms
// Medium (56.91%)
// Total Accepted:    470,095
// Total Submissions: 825,969
// beats 100.0% of golang submissions

package leetcode

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var res []int

func inorderTraversalV1(root *TreeNode) []int {
	res = []int{}

	recursive(root)

	return res
}

func recursive(root *TreeNode) {
	if root == nil {
		return
	}

	recursive(root.Left)
	res = append(res, root.Val)
	recursive(root.Right)
}

func inorderTraversalV2(root *TreeNode) []int {
	var res []int
	if root == nil {
		return res
	}

	var stack []*TreeNode

	for len(stack) > 0 || root != nil {
		if root != nil {
			for root != nil {
				stack = append(stack, root)
				root = root.Left
			}
		} else {
			stackLen := len(stack)
			lastNode := stack[stackLen-1]
			stack = stack[:stackLen-1]
			res = append(res, lastNode.Val)
			root = lastNode.Right
		}
	}

	return res
}
