// https://leetcode.com/problems/powx-n/
//
// algorithms
// Medium (27.15%)
// Total Accepted:    271,253
// Total Submissions: 998,971
// beats 100.0% of golang submissions

package leetcode

import "math"

func myPow(x float64, n int) float64 {
	if n == 0 {
		return 1.0
	}
	if n < 0 {
		if n == math.MinInt32 {
			return 1.0 / myPow(x, math.MaxInt32) * x
		}
		return 1.0 / myPow(x, -n)
	}

	half := myPow(x, n>>1)

	if n&1 == 0 {
		return half * half
	}
	return half * half * x
}
