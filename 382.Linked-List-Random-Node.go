// https://leetcode.com/problems/linked-list-random-node/description/
//
// algorithms
// Medium (48.15%)
// Total Accepted:    45.7K
// Total Submissions: 94.9K
// beats 69.23% of golang submissions
// 水塘抽样

package leetcode

import "math/rand"

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
type Solution struct {
	head *ListNode
}

/** @param head The linked list's head.
  Note that the head is guaranteed to be not null, so it contains at least one node. */
func Constructor(head *ListNode) Solution {
	return Solution{
		head: head,
	}
}

/** Returns a random node's value. */
func (this *Solution) GetRandom() int {
	node := this.head
	count := 1
	res := -1

	for node != nil {
		if rand.Intn(count) == 0 {
			res = node.Val
		}
		node = node.Next
		count++
	}

	return res
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(head);
 * param_1 := obj.GetRandom();
 */
