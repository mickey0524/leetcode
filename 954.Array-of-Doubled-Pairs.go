// https://leetcode.com/problems/array-of-doubled-pairs/
//
// algorithms
// Medium (31.7%)
// Total Accepted:    3,431
// Total Submissions: 10,823
// beats 61.54% of golang submissions

package leetcode

import "sort"

func canReorderDoubled(A []int) bool {
	hashMap := make(map[int]int)
	nums := []int{}

	for _, n := range A {
		if n < 0 {
			n = -n
		}
		if v, ok := hashMap[n]; ok {
			hashMap[n] = v + 1
		} else {
			hashMap[n] = 1
			nums = append(nums, n)
		}
	}

	sort.Sort(sort.IntSlice(nums))

	for _, n := range nums {
		for {
			v, ok := hashMap[n]
			if ok && v > 0 {
				hashMap[n]--
				v2, exist := hashMap[2*n]
				if !exist || v2 == 0 {
					return false
				}
				hashMap[2*n]--
			} else {
				break
			}
		}
	}

	return true
}
