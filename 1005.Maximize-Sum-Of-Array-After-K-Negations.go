// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
//
// algorithms
// Easy (45.09%)
// Total Accepted:    2,968
// Total Submissions: 6,582
// beats 100.0% of golang submissions

package leetcode

import "sort"

func largestSumAfterKNegations(A []int, K int) int {
	length := len(A)

	sort.Sort(sort.IntSlice(A))
	i := 0

	for K > 0 && i < length {
		if A[i] >= 0 {
			break
		}
		A[i] = -A[i]
		i++
		K--
	}

	if K == 0 || i == length || A[i] == 0 {
		return sum(A)
	}

	K %= 2
	if K == 1 {
		if i > 0 && A[i] > A[i-1] {
			A[i-1] = -A[i-1]
		} else {
			A[i] = -A[i]
		}
	}

	return sum(A)
}

func sum(A []int) int {
	res := 0

	for _, n := range A {
		res += n
	}

	return res
}
