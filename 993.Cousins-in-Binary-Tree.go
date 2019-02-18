// https://leetcode.com/problems/cousins-in-binary-tree/
//
// algorithms
// Easy (54.74%)
// Total Accepted:    3,804
// Total Submissions: 6,949
// beats 100.0% of golang submissions

package leetcode

import (
	"fmt"
	"strings"
)

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
var xFlag, yFlag string
var format = "%d#%d"

func isCousins(root *TreeNode, x int, y int) bool {
	if root.Val == x || root.Val == y {
		return false
	}

	xFlag, yFlag = "#", "#"

	recursive(root, x, y, 0)

	xArr, yArr := strings.Split(xFlag, "#"), strings.Split(yFlag, "#")

	if xArr[0] != yArr[0] && xArr[1] == yArr[1] {
		return true
	}

	return false
}

func recursive(node *TreeNode, x, y, depth int) {
	if xFlag != "#" && yFlag != "#" {
		return
	}
	if node.Left != nil {
		if node.Left.Val == x {
			xFlag = fmt.Sprintf(format, node.Val, depth+1)
			return
		}
		if node.Left.Val == y {
			yFlag = fmt.Sprintf(format, node.Val, depth+1)
			return
		}
		recursive(node.Left, x, y, depth+1)
	}
	if node.Right != nil {
		if node.Right.Val == x {
			xFlag = fmt.Sprintf(format, node.Val, depth+1)
			return
		}
		if node.Right.Val == y {
			yFlag = fmt.Sprintf(format, node.Val, depth+1)
			return
		}
		recursive(node.Right, x, y, depth+1)
	}
}
