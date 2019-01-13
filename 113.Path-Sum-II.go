// https://leetcode.com/problems/path-sum-ii/
//
// algorithms
// Medium (38.8%)
// Total Accepted:    204,612
// Total Submissions: 527,303
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
var res [][]int

func pathSum(root *TreeNode, sum int) [][]int {
	res = [][]int{}
	if root == nil {
		return res
	}

	resursive(root, []int{}, sum, 0)

	return res
}

func resursive(node *TreeNode, path []int, sum, cntS int) {
	if node.Left == nil && node.Right == nil {
		if cntS+node.Val == sum {
			tmp := make([]int, len(path))
			copy(tmp, path)
			tmp = append(tmp, node.Val)
			res = append(res, tmp)
		}
		return
	}
	path = append(path, node.Val)
	if node.Left != nil {
		resursive(node.Left, path, sum, cntS+node.Val)
	}
	if node.Right != nil {
		resursive(node.Right, path, sum, cntS+node.Val)
	}
	path = path[:len(path)-1]
}
