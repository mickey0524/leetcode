// https://leetcode.com/problems/valid-mountain-array/description/
//
// algorithms
// Easy (33.3%)
// Total Accepted:    3k
// Total Submissions: 9k

package leetcode

func validMountainArray(A []int) bool {
	length := len(A)

	if length < 3 {
		return false
	}

	if A[1] < A[0] {
		return false
	}

	up := true

	for i := 1; i < length; i++ {
		if A[i] == A[i-1] {
			return false
		}
		if up {
			if A[i] < A[i-1] {
				up = false
			}
		} else {
			if A[i] > A[i-1] {
				return false
			}
		}
	}

	if up {
		return false
	}
	return true
}
