// https://leetcode.com/problems/add-to-array-form-of-integer/
//
// algorithms
// Medium (43.39%)
// Total Accepted:    3,113
// Total Submissions: 7,175
// beats 100.0% of golang submissions

package leetcode

import "strconv"

func addToArrayForm(A []int, K int) []int {
	kArr := []byte(strconv.Itoa(K))
	aLen, kLen := len(A), len(kArr)

	carry := 0
	var res []int

	for i := 0; i < max(aLen, kLen); i++ {
		sum := carry
		if i < aLen {
			sum += A[aLen-1-i]
		}
		if i < kLen {
			sum += int(kArr[kLen-1-i] - '0')
		}
		carry = sum / 10
		sum %= 10
		res = append([]int{sum}, res...)
	}

	if carry > 0 {
		res = append([]int{carry}, res...)
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
