// https://leetcode.com/problems/ugly-number/
//
// algorithms
// Easy (40.71%)
// Total Accepted:    160,903
// Total Submissions: 395,226
// beats 100.0% of golang submissions

package leetcode

func isUgly(num int) bool {
	if num < 1 {
		return false
	}
	for num%2 == 0 {
		num /= 2
	}

	for num%3 == 0 {
		num /= 3
	}

	for num%5 == 0 {
		num /= 5
	}

	return num == 1
}
