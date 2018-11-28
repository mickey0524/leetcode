// https://leetcode.com/problems/remove-linked-list-elements/description/
//
// algorithms
// Easy (34.6%)
// Total Accepted:    188.8K
// Total Submissions: 545.6K
// beats 100.0% of golang submissions

package leetcode

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeElements(head *ListNode, val int) *ListNode {
	for head != nil && head.Val == val {
		head = head.Next
	}

	res := head
	for res != nil && res.Next != nil {
		for res.Next != nil && res.Next.Val == val {
			res.Next = res.Next.Next
		}
		res = res.Next
	}

	return head
}
