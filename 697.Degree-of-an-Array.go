// https://leetcode.com/problems/degree-of-an-array/description/
//
// algorithms
// Easy (47.6%)
// Total Accepted:    33k
// Total Submissions: 69.3k
// beats 100.0% of golang submissions

package leetcode

type line struct {
	start int
	end   int
}

func findShortestSubArray(nums []int) int {
	freq := make(map[int]int)
	lines := make(map[int]*line)

	for idx, n := range nums {
		if _, ok := freq[n]; ok {
			freq[n]++
			lines[n].end = idx
		} else {
			freq[n] = 1
			lines[n] = &line{
				start: idx,
			}
		}
	}

	cntMaxFreq := -1
	res := 0

	for k, v := range freq {
		if v > cntMaxFreq {
			cntMaxFreq = v
			res = lines[k].end - lines[k].start
		} else if v == cntMaxFreq && (lines[k].end-lines[k].start) < res {
			res = lines[k].end - lines[k].start
		}
	}

	if res < 0 {
		return 1
	}

	return res + 1
}
