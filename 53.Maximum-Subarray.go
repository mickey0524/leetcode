// https://leetcode.com/problems/maximum-subarray/description/
//
// algorithms
// Easy (41.6%)
// Total Accepted:    393.4k
// Total Submissions: 945.7k
// beats 100.0% of golang submissions

package leetcode

func maxSubArray(nums []int) int {
	res, cntSum := -(1 << 31), -1

	for _, n := range nums {
		if cntSum < 0 {
			cntSum = n
		} else {
			cntSum += n
		}
		if cntSum > res {
			res = cntSum
		}
	}

	return res
}
