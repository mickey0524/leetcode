// https://leetcode.com/problems/perfect-number/
//
// algorithms
// Easy (32.98%)
// Total Accepted:    33,179
// Total Submissions: 100,604
// beats 100.0% of golang submissions

package leetcode

import "math"

func checkPerfectNumber(num int) bool {
	if num <= 5 {
		return false
	}

	tmp := num - 1
	for i := 2; i < int(math.Ceil(math.Sqrt(float64(num)))); i++ {
		if num%i == 0 {
			tmp -= i + (num / i)
		}
		if tmp < 0 {
			return false
		}
	}

	if tmp == 0 {
		return true
	}
	return false
}
