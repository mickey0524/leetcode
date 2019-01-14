// https://leetcode.com/problems/linked-list-cycle-ii/
//
// algorithms
// Medium (30.29%)
// Total Accepted:    187,091
// Total Submissions: 617,612
// beats 100.0% of golang submissions

package leetcode

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func detectCycle(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return nil
	}

	first, two := head.Next, head.Next.Next
	hasCycle := false

	for first != nil && two != nil {
		if first == two {
			hasCycle = true
			break
		}
		first = first.Next
		if two.Next == nil {
			break
		}
		two = two.Next.Next
	}

	if !hasCycle {
		return nil
	}

	first = first.Next
	length := 1
	for first != two {
		first = first.Next
		length++
	}

	first, two = head, head
	for i := 0; i < length; i++ {
		first = first.Next
	}

	for first != two {
		first = first.Next
		two = two.Next
	}

	return first
}
