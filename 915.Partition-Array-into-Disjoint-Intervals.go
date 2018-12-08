// https://leetcode.com/problems/partition-array-into-disjoint-intervals/
//
// algorithms
// Medium (40.45%)
// Total Accepted:    6,387
// Total Submissions: 15,790

package leetcode

func partitionDisjoint(A []int) int {
	length := len(A)

	bigest, smallest := make([]int, length), make([]int, length)

	bigest[0] = A[0]
	smallest[length-1] = A[length-1]

	for i := 1; i < length; i++ {
		if A[i] > bigest[i-1] {
			bigest[i] = A[i]
		} else {
			bigest[i] = bigest[i-1]
		}
	}

	for i := length - 2; i >= 0; i-- {
		if A[i] < smallest[i+1] {
			smallest[i] = A[i]
		} else {
			smallest[i] = smallest[i+1]
		}
	}

	for i := 0; i < length-1; i++ {
		if bigest[i] <= smallest[i+1] {
			return i + 1
		}
	}

	return 0
}
