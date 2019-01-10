// https://leetcode.com/problems/partition-equal-subset-sum/description/
//
// algorithms
// Easy (42.66%)
// Total Accepted:    79,325
// Total Submissions: 185,930

package leetcode

import "strconv"

func addStrings(num1 string, num2 string) string {
	len1, len2 := len(num1), len(num2)
	if len1 == 0 {
		return num2
	}
	if len2 == 0 {
		return num1
	}

	res := ""
	carry := 0
	for i := 0; i < max(len1, len2); i++ {
		bit := carry
		if i < len1 {
			bit += int(num1[len1-1-i] - '0')
		}
		if i < len2 {
			bit += int(num2[len2-1-i] - '0')
		}
		carry = bit / 10
		res = strconv.Itoa(bit%10) + res
	}

	if carry != 0 {
		res = strconv.Itoa(carry) + res
	}

	return res
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
