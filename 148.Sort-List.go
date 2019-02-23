// https://leetcode.com/problems/sort-list/
//
// algorithms
// Hard (33.79%)
// Total Accepted:    168,913
// Total Submissions: 499,908
// beats 100.0% of golang submissions

// 如果不允许直接修改 node.Val，那就先找到中间节点，再归并排序
package leetcode

import "sort"

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func sortList(head *ListNode) *ListNode {
	var vals []int

	for tmp := head; tmp != nil; {
		vals = append(vals, tmp.Val)
		tmp = tmp.Next
	}

	sort.Sort(sort.IntSlice(vals))

	tmp := head
	for _, n := range vals {
		tmp.Val = n
		tmp = tmp.Next
	}

	return head
}
