// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
//
// algorithms
// Medium (36.52%)
// Total Accepted:    129.2K
// Total Submissions: 353.8K

package leetcode

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(inorder []int, postorder []int) *TreeNode {
	length := len(inorder)
	if length == 0 {
		return nil
	}

	return resursive(inorder, postorder, 0, length-1, 0, length-1)
}

func resursive(inorder, postorder []int, inHead, inTail, postHead, postTail int) *TreeNode {
	if inHead > inTail {
		return nil
	}
	if inHead == inTail {
		return &TreeNode{
			Val: inorder[inHead],
		}
	}

	root := &TreeNode{
		Val: postorder[postTail],
	}

	idx := inHead
	for ; idx <= inTail; idx++ {
		if inorder[idx] == postorder[postTail] {
			break
		}
	}

	root.Left = resursive(inorder, postorder, inHead, idx-1, postHead, postHead+idx-inHead-1)
	root.Right = resursive(inorder, postorder, idx+1, inTail, postHead+idx-inHead, postTail-1)

	return root
}
