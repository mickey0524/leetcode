// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
//
// algorithms
// Medium (64.05%)
// Total Accepted:    2,156
// Total Submissions: 3,366
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

var deepestLeaves map[*TreeNode]bool
var res *TreeNode
var curMaxHeight int

func lcaDeepestLeaves(root *TreeNode) *TreeNode {
	if root == nil {
		return root
	}

	deepestLeaves = make(map[*TreeNode]bool)
	curMaxHeight = -1
	getDeepestLeaves(root, 0)

	res = nil
	recursive(root, len(deepestLeaves))

	return res
}

func getDeepestLeaves(root *TreeNode, depth int) {
	if root.Left == nil && root.Right == nil {
		if depth >= curMaxHeight {
			if depth > curMaxHeight {
				deepestLeaves = make(map[*TreeNode]bool)
				curMaxHeight = depth
			}
			deepestLeaves[root] = true
		}

		return
	}

	if root.Left != nil {
		getDeepestLeaves(root.Left, depth+1)
	}

	if root.Right != nil {
		getDeepestLeaves(root.Right, depth+1)
	}
}

func recursive(root *TreeNode, leafNum int) int {
	if res != nil || root == nil {
		return 0
	}

	l, r := recursive(root.Left, leafNum), recursive(root.Right, leafNum)
	sum := l + r
	if _, exist := deepestLeaves[root]; exist {
		sum += 1
	}

	if sum == leafNum && res == nil {
		res = root
	}

	return sum
}
