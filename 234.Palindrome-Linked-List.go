// https://leetcode.com/problems/palindrome-linked-list/
//
// algorithms
// Easy (34.81%)
// Total Accepted:    214,702
// Total Submissions: 616,829
// beats 100.0% of golang submissions

package leetcode

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func isPalindrome(head *ListNode) bool {
	if head == nil || head.Next == nil {
		return true
	}

	oneStep, twoStep := head, head
	var pre, tmp, preTmp *ListNode
	var left, right *ListNode

	for {
		if twoStep.Next == nil {
			left = pre
			right = oneStep.Next
			break
		}
		if twoStep.Next.Next == nil {
			left = oneStep
			right = oneStep.Next
			left.Next = pre
			break
		}
		twoStep = twoStep.Next.Next
		tmp = oneStep.Next
		preTmp = pre
		pre = oneStep
		pre.Next = preTmp

		oneStep = tmp
	}

	for left != nil && right != nil {
		if left.Val != right.Val {
			return false
		}
		left = left.Next
		right = right.Next
	}

	return true
}
