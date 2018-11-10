// https://leetcode.com/problems/split-linked-list-in-parts/description/
//
// algorithms
// Medium (47.5%)
// Total Accepted:    19k
// Total Submissions: 40k
// beats 33.3% of golang submissions

package leetcode

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func splitListToParts(root *ListNode, k int) []*ListNode {
	res := make([]*ListNode, k)

	listLength := 0
	head := root
	for {
		if head == nil {
			break
		}
		head = head.Next
		listLength++
	}

	splitLength := make([]int, k)
	base := listLength / k
	last := listLength % k

	for i := 0; i < k; i++ {
		splitLength[i] += base
		if i < last {
			splitLength[i] += 1
		}
	}

	for i := 0; i < k; i++ {
		if splitLength[i] == 0 {
			break
		}
		res[i] = root
		var before *ListNode
		for j := 0; j < splitLength[i]; j++ {
			before = root
			root = root.Next
		}
		if before != nil {
			before.Next = nil
		}
	}

	return res
}
