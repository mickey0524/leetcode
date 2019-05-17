// https://leetcode.com/problems/merge-two-sorted-lists/
//
// algorithms
// Easy (47.08%)
// Total Accepted:    573,963
// Total Submissions: 1,219,119
// beats 100.0% of golang submissions

package leetcode

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	tmp := ListNode{}
	res := &tmp

	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			res.Next = l1
			l1 = l1.Next
		} else {
			res.Next = l2
			l2 = l2.Next
		}
		res = res.Next
	}

	if l2 != nil {
		res.Next = l2
	}

	if l1 != nil {
		res.Next = l1
	}

	return tmp.Next
}
