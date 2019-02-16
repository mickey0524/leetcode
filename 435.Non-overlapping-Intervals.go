// https://leetcode.com/problems/non-overlapping-intervals/
//
// algorithms
// Medium (41.33%)
// Total Accepted:    33,096
// Total Submissions: 80,077
// beats 100.0% of golang submissions

package leetcode

import "sort"

/**
 * Definition for an interval.
 * type Interval struct {
 *	   Start int
 *	   End   int
 * }
 */
func eraseOverlapIntervals(intervals []Interval) int {
	length := len(intervals)

	if length < 2 {
		return 0
	}

	sort.Slice(intervals, func(i, j int) bool {
		if intervals[i].End < intervals[j].End {
			return true
		}
		return false
	})

	curEnd := -(1 << 31)
	var res int

	for _, i := range intervals {
		if i.Start >= curEnd {
			curEnd = i.End
		} else {
			res++
		}
	}

	return res
}
