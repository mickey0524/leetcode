// https://leetcode.com/problems/next-greater-node-in-linked-list/
//
// algorithms
// Medium (52.55%)
// Total Accepted:    2,601
// Total Submissions: 4,950
// beats 100.0% of golang submissions

package leetcode

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

type stackItem struct {
	val int
	idx int
}

func nextLargerNodes(head *ListNode) []int {
	if head == nil {
		return []int{}
	}

	if head.Next == nil {
		return []int{0}
	}

	tmp := head
	length := 0
	for tmp != nil {
		length++
		tmp = tmp.Next
	}

	res := make([]int, length)
	var stack []stackItem
	curIdx := 0

	for head != nil {
		stackLen := len(stack)
		if stackLen == 0 || head.Val <= stack[stackLen-1].val {
			stack = append(stack, stackItem{
				val: head.Val,
				idx: curIdx,
			})
		} else {
			for stackLen > 0 && head.Val > stack[stackLen-1].val {
				res[stack[stackLen-1].idx] = head.Val
				stackLen--
				stack = stack[:stackLen]
			}
			stack = append(stack, stackItem{
				val: head.Val,
				idx: curIdx,
			})
		}
		curIdx++
		head = head.Next
	}

	return res

}
