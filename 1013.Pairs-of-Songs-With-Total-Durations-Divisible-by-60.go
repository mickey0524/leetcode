// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
//
// algorithms
// Easy (41.5%)
// Total Accepted:    4,134
// Total Submissions: 9,961
// beats 100.0% of golang submissions

package leetcode

func numPairsDivisibleBy60(time []int) int {
	remainders := make([]int, 60)

	var res int

	for _, t := range time {
		r := t % 60
		var relaT int
		if r > 0 {
			relaT = 60 - r
		}
		res += remainders[relaT]
		remainders[r]++
	}

	return res
}
