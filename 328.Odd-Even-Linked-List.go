// https://leetcode.com/problems/odd-even-linked-list/
//
// algorithms
// Medium (47.49%)
// Total Accepted:    126,006
// Total Submissions: 265,319

package leetcode

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func oddEvenList(head *ListNode) *ListNode {
	oddList := &ListNode{}
	oddListTmp := oddList
	needSwap := false
	headTmp := head
	var pre *ListNode

	for headTmp != nil {
		if needSwap {
			pre.Next = headTmp.Next
			oddListTmp.Next = headTmp
			headTmp.Next = nil
			oddListTmp = oddListTmp.Next
			headTmp = pre.Next
		} else {
			pre = headTmp
			headTmp = headTmp.Next
		}
		needSwap = !needSwap
	}

	if pre != nil {
		pre.Next = oddList.Next
	}

	return head
}

func oddEvenList1(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}

	odd, even := head, head.Next
	tmp := even

	for odd != nil && even != nil && even.Next != nil {
		odd.Next = odd.Next.Next
		even.Next = even.Next.Next

		odd = odd.Next
		even = even.Next
	}

	odd.Next = tmp

	return head
}
