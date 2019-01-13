// https://leetcode.com/problems/path-sum-iii/
//
// algorithms
// Easy (41.38%)
// Total Accepted:    86,391
// Total Submissions: 208,789
// beats 83.33% of golang submissions

package leetcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var pathSumRes int

func pathSum(root *TreeNode, sum int) int {
	if root == nil {
		return 0
	}

	pathSumRes = 0

	resursive(root, sum)

	return pathSumRes
}

func resursive(node *TreeNode, sum int) []int {
	if node.Left == nil && node.Right == nil {
		if node.Val == sum {
			pathSumRes++
		}
		return []int{node.Val}
	}

	res := []int{node.Val}
	if node.Val == sum {
		pathSumRes++
	}
	if node.Left != nil {
		leftArr := resursive(node.Left, sum)
		for idx, n := range leftArr {
			leftArr[idx] = n + node.Val
			if leftArr[idx] == sum {
				pathSumRes++
			}
		}
		res = append(res, leftArr...)
	}
	if node.Right != nil {
		rightArr := resursive(node.Right, sum)
		for idx, n := range rightArr {
			rightArr[idx] = n + node.Val
			if rightArr[idx] == sum {
				pathSumRes++
			}
		}
		res = append(res, rightArr...)
	}

	return res
}
