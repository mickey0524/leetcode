// https://leetcode.com/problems/longest-turbulent-subarray/
//
// algorithms
// Medium (47.51%)
// Total Accepted:    3,286
// Total Submissions: 6,916
// beats 100.0% of golang submissions

package leetcode

func maxTurbulenceSize(A []int) int {
	length := len(A)
	if length < 2 {
		return length
	}

	head, tail := 0, 1
	res := 1
	direction := 0

	for ; tail < length; tail++ {
		if A[tail] == A[tail-1] {
			res = max(res, tail-1-head+1)
			head = tail
			direction = 0
		} else {
			if direction == 0 {
				if A[tail] > A[tail-1] {
					direction = -1
				} else {
					direction = 1
				}
			} else if (direction == 1 && A[tail] < A[tail-1]) ||
				(direction == -1 && A[tail] > A[tail-1]) {
				res = max(res, tail-1-head+1)
				head = tail - 1
			} else {
				direction = -direction
			}
		}
	}

	res = max(res, tail-head)

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
