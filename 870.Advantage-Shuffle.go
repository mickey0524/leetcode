// https://leetcode.com/problems/advantage-shuffle/
//
// algorithms
// Medium (40.39%)
// Total Accepted:    7,715
// Total Submissions: 19,098

package leetcode

import "sort"

func advantageCount(A []int, B []int) []int {
	length := len(A)
	bTmp := make([]int, length)
	copy(bTmp, B)

	sort.Sort(sort.IntSlice(A))
	sort.Sort(sort.Reverse(sort.IntSlice(B)))

	head, tail := 0, length-1
	hashMap := make(map[int][]int)
	res := make([]int, length)

	for _, n := range B {
		if n >= A[tail] {
			if _, ok := hashMap[n]; ok {
				hashMap[n] = append(hashMap[n], A[head])
			} else {
				hashMap[n] = []int{A[head]}
			}
			head++
		} else {
			if _, ok := hashMap[n]; ok {
				hashMap[n] = append(hashMap[n], A[tail])
			} else {
				hashMap[n] = []int{A[tail]}
			}
			tail--
		}
	}

	existMap := make(map[int]int)

	for idx, n := range bTmp {
		if existIdx, ok := existMap[n]; ok {
			res[idx] = hashMap[n][existIdx]
			existMap[n] = existIdx + 1
		} else {
			res[idx] = hashMap[n][0]
			existMap[n] = 1
		}
	}

	return res
}
