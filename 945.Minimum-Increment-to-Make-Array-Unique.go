package leetcode

import "sort"

// https://leetcode.com/problems/minimum-increment-to-make-array-unique/
//
// algorithms
// Medium (39.3%)
// Total Accepted:    4,422
// Total Submissions: 11,252

func minIncrementForUnique(A []int) int {
	length := len(A)
	if length == 0 {
		return 0
	}

	res := 0
	waitSlice := []int{}

	sort.Sort(sort.IntSlice(A))
	lastN := A[0]
	for _, num := range A[1:] {
		if num == lastN {
			waitSlice = append(waitSlice, num)
		} else if num-lastN > 1 {
			seat := num - lastN - 1
			waitSliceLen := len(waitSlice)
			if waitSliceLen < seat {
				seat = waitSliceLen
			}
			for i := 0; i < seat; i++ {
				res += (lastN + 1 + i - waitSlice[i])
			}
			waitSlice = waitSlice[seat:]
		}

		lastN = num
	}

	seat := A[length-1] + 1
	for _, num := range waitSlice {
		res += (seat - num)
		seat++
	}

	return res
}
