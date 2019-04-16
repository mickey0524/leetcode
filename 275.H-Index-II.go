// https://leetcode.com/problems/h-index-ii/
//
// algorithms
// Medium (35.33%)
// Total Accepted:    77,755
// Total Submissions: 220,113
// beats 100.0% of golang submissions

package leetcode

func hIndex(citations []int) int {
	length := len(citations)
	if length == 0 {
		return 0
	}

	l, r, m := 0, length-1, -1
	for l < r {
		m = l + (r-l)/2
		if citations[m] >= length-m {
			r = m
		} else {
			l = m + 1
		}
	}

	if citations[l] >= length-l {
		return length - l
	}

	return 0
}
