// https://leetcode.com/problems/continuous-subarray-sum/
//
// algorithms
// Medium (23.97%)
// Total Accepted:    54,376
// Total Submissions: 226,870
// beats 100.0% of golang submissions

package leetcode

func checkSubarraySum(nums []int, k int) bool {
	if k < 0 {
		k = -k
	}

	length := len(nums)
	if length < 2 {
		return false
	}

	if k == 1 {
		return true
	}

	if k == 0 {
		zeroIdx := -2
		for idx, n := range nums {
			if n == 0 {
				if idx == zeroIdx+1 {
					return true
				}
				zeroIdx = idx
			}
		}
		return false
	}

	dp := make(map[int]int)
	dp[0] = -1
	s := 0
	for idx, n := range nums {
		s += n
		remainder := s % k
		if v, ok := dp[remainder]; ok {
			if idx-v >= 2 {
				return true
			}
		} else {
			dp[remainder] = idx
		}
	}

	return false
}
