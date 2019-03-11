// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
//
// algorithms
// Medium (48.9%)
// Total Accepted:    3,282
// Total Submissions: 6,711

package leetcode

func minDominoRotations(A []int, B []int) int {
	length := len(A)
	ANum, BNum := make([]int, 7), make([]int, 7)

	for i := 0; i < length; i++ {
		ANum[A[i]]++
		BNum[B[i]]++
	}

	res := 0

	for i := 1; i < 7; i++ {
		if ANum[i]+BNum[i] >= length {
			useA := false
			if ANum[i] >= BNum[i] {
				useA = true
			}
			for idx := 0; idx < length; idx++ {
				if A[idx] != i && B[idx] != i {
					return -1
				}
				if A[idx] != i && B[idx] == i && useA {
					res++
				}
				if A[idx] == i && B[idx] != i && !useA {
					res++
				}
			}
			return res
		}
	}

	return -1
}
