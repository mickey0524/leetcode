// https://leetcode.com/problems/smallest-string-starting-from-leaf/
//
// algorithms
// Medium (52.19%)
// Total Accepted:    3,509
// Total Submissions: 6,724
// beats 100.0% of golang submissions

package leetcode

import "bytes"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func smallestFromLeaf(root *TreeNode) string {
	if root == nil {
		return ""
	}

	arr := recursive(root)

	res := bytes.NewBufferString("")
	for _, n := range arr {
		res.WriteByte(byte(n + 97))
	}

	return res.String()
}

func recursive(node *TreeNode) []int {
	if node.Left == nil && node.Right == nil {
		return []int{node.Val}
	}
	var left, right []int

	if node.Left != nil {
		left = recursive(node.Left)
	}
	if node.Right != nil {
		right = recursive(node.Right)
	}

	leftLen, rightLen := len(left), len(right)
	left = append(left, node.Val)
	right = append(right, node.Val)
	if leftLen == 0 {
		return right
	}
	if rightLen == 0 {
		return left
	}

	i, j := 0, 0
	for i < leftLen && j < rightLen {
		if left[i] < right[j] {
			return left
		} else if left[i] > right[j] {
			return right
		}
		i++
		j++
	}
	if leftLen == rightLen || i == leftLen {
		return left
	}
	return right
}
