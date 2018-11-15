// https://leetcode.com/problems/reverse-linked-list/description/
//
// algorithms
// Easy (50.50%)
// Total Accepted:    448.8K
// Total Submissions: 888.7K
// beats 100.0% of golang submissions

package leetcode

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseList(head *ListNode) *ListNode {
	tmp := &ListNode{}

	for {
		if head == nil {
			break
		}
		nextNode := head.Next
		head.Next = tmp.Next
		tmp.Next = head
		head = nextNode
	}

	return tmp.Next
}
