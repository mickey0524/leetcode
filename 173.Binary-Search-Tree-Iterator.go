// https://leetcode.com/problems/binary-search-tree-iterator/
//
// algorithms
// Medium (45.79%)
// Total Accepted:    172,665
// Total Submissions: 377,082
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
type BSTIterator struct {
	valArr []int
	cntIdx int
}

func Constructor(root *TreeNode) BSTIterator {
	var valArr []int
	resursive(root, &valArr)
	return BSTIterator{
		valArr: valArr,
		cntIdx: 0,
	}
}

func resursive(root *TreeNode, valArr *[]int) {
	if root == nil {
		return
	}
	resursive(root.Left, valArr)
	*valArr = append(*valArr, root.Val)
	resursive(root.Right, valArr)
}

/** @return the next smallest number */
func (this *BSTIterator) Next() int {
	res := this.valArr[this.cntIdx]
	this.cntIdx++

	return res
}

/** @return whether we have a next smallest number */
func (this *BSTIterator) HasNext() bool {
	return this.cntIdx < len(this.valArr)
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * obj := Constructor(root);
 * param_1 := obj.Next();
 * param_2 := obj.HasNext();
 */
