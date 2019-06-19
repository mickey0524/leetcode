// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//
// algorithms
// Medium (41.46%)
// Total Accepted:    228,336
// Total Submissions: 550,706

package leetcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
	length := len(preorder)

	return recursive(preorder, inorder, 0, length-1, 0, length-1)
}

func recursive(preorder, inorder []int, preStart, preEnd, inStart, inEnd int) *TreeNode {
	if preStart > preEnd {
		return nil
	}

	if preStart == preEnd {
		return &TreeNode{
			Val: preorder[preStart],
		}
	}

	var rootIdx int
	for i := inStart; i <= inEnd; i++ {
		if inorder[i] == preorder[preStart] {
			rootIdx = i
			break
		}
	}

	root := &TreeNode{
		Val: preorder[preStart],
	}

	root.Left = recursive(preorder, inorder, preStart+1, preStart+rootIdx-inStart, inStart, rootIdx-1)
	root.Right = recursive(preorder, inorder, preStart+rootIdx-inStart+1, preEnd, rootIdx+1, inEnd)

	return root
}
