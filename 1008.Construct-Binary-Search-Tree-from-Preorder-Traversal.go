// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
//
// algorithms
// Medium (71.86%)
// Total Accepted:    2,120
// Total Submissions: 2,950
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
func bstFromPreorder(preorder []int) *TreeNode {
	length := len(preorder)

	if length == 0 {
		return nil
	}

	root := &TreeNode{
		Val: preorder[0],
	}

	i := 1
	for ; i < length; i++ {
		if preorder[i] > preorder[0] {
			break
		}
	}

	root.Left = bstFromPreorder(preorder[1:i])
	if i < length {
		root.Right = bstFromPreorder(preorder[i:])
	}

	return root
}
