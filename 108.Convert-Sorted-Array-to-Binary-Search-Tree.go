// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//
// algorithms
// Easy (52.52%)
// Total Accepted:    294,117
// Total Submissions: 560,015

package leetcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sortedArrayToBST(nums []int) *TreeNode {
	length := len(nums)
	if length == 0 {
		return nil
	}
	if length == 1 {
		return &TreeNode{
			Val: nums[0],
		}
	}

	middle := length / 2
	node := &TreeNode{
		Val: nums[middle],
	}
	node.Left = sortedArrayToBST(nums[:middle])
	node.Right = sortedArrayToBST(nums[middle+1:])

	return node
}
