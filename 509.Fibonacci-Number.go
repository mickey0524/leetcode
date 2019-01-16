// https://leetcode.com/problems/fibonacci-number/
//
// algorithms
// Easy (67.58%)
// Total Accepted:    5,925
// Total Submissions: 8,768
// beats 100.0% of golang submissions

package leetcode

func fib(N int) int {
	if N == 0 {
		return 0
	}
	if N == 1 {
		return 1
	}

	a, b := 0, 1
	for i := 2; i <= N; i++ {
		tmp := a + b
		a = b
		b = tmp
	}

	return b
}
