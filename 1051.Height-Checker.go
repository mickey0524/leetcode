// https://leetcode.com/problems/height-checker/
//
// algorithms
// Easy (67.52%)
// Total Accepted:    2,542
// Total Submissions: 3,765
// beats 100.0% of golang submissions

package leetcode

import "sort"

func heightChecker(heights []int) int {
	length := len(heights)

	tmp := make([]int, length)
	copy(tmp, heights)
	sort.Sort(sort.IntSlice(heights))

	var res int

	for i := 0; i < length; i++ {
		if heights[i] != tmp[i] {
			res++
		}
	}

	return res
}
