// https://leetcode.com/problems/plus-one/
//
// algorithms
// Easy (40.37%)
// Total Accepted:    327,582
// Total Submissions: 812,114
// beats 100.0% of golang submissions

package leetcode

func plusOne(digits []int) []int {
	length := len(digits)

	if digits[length-1] != 9 {
		digits[length-1]++
		return digits
	}

	digits[length-1] = 0
	idx := length - 2
	for ; idx >= 0; idx-- {
		if digits[idx] != 9 {
			digits[idx]++
			return digits
		} else {
			digits[idx] = 0
		}
	}

	digits = append([]int{1}, digits...)

	return digits
}
