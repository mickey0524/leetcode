// https://leetcode.com/problems/palindrome-linked-list/
//
// algorithms
// Easy (44.65%)
// Total Accepted:    280,819
// Total Submissions: 628,935

package leetcode

/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */
func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	for {
		if root.Val == q.Val || root.Val == p.Val {
			return root
		} else if root.Val > p.Val && root.Val > q.Val {
			root = root.Left
		} else if root.Val < p.Val && root.Val < q.Val {
			root = root.Right
		} else {
			return root
		}
	}

	return nil
}
