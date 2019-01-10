// https://leetcode.com/problems/add-two-numbers/
//
// algorithms
// Medium (30.1%)
// Total Accepted:    707,610
// Total Submissions: 2,350,674

package leetcode

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	arr1, arr2 := genIntArr(l1), genIntArr(l2)
	len1, len2 := len(arr1), len(arr2)
	res := &ListNode{}
	tmp := res
	carry := 0

	for i := 0; i < max(len1, len2); i++ {
		bit := carry
		if i < len1 {
			bit += arr1[len1-1-i]
		}
		if i < len2 {
			bit += arr2[len2-1-i]
		}
		carry = bit / 10
		tmp.Next = &ListNode{
			Val: bit % 10,
		}
		tmp = tmp.Next
	}

	if carry > 0 {
		tmp.Next = &ListNode{
			Val: carry,
		}
	}

	return res.Next
}

func genIntArr(l *ListNode) []int {
	var res []int

	for l != nil {
		res = append([]int{l.Val}, res...)
		l = l.Next
	}

	return res
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
