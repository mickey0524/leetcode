// https://leetcode.com/problems/power-of-four/
//
// algorithms
// Easy (39.78%)
// Total Accepted:    101,141
// Total Submissions: 254,245
// beats 100.0% of golang submissions

package leetcode

import "math"

func isPowerOfFour(num int) bool {
	mod := math.Log(float64(num)) / math.Log(4.0)
	return float64(int(mod)) == mod
}
