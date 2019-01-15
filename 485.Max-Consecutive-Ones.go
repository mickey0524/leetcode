// https://leetcode.com/problems/max-consecutive-ones/
//
// algorithms
// Easy (54.26%)
// Total Accepted:    117,836
// Total Submissions: 217,188
// beats 100.0% of golang submissions

package leetcode

func findMaxConsecutiveOnes(nums []int) int {
	res := 0
	cntNum := 0

	for _, n := range nums {
		if n == 0 {
			res = max(res, cntNum)
			cntNum = 0
		} else {
			cntNum++
		}
	}

	return max(res, cntNum)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
