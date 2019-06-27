// https://leetcode.com/problems/minimum-size-subarray-sum/
//
// algorithms
// Medium (35.05%)
// Total Accepted:    181,125
// Total Submissions: 516,698
// beats 100.0% of golang submissions

package leetcode

func minSubArrayLen(s int, nums []int) int {
	length := len(nums)

	if length == 0 {
		return 0
	}

	if nums[0] >= s {
		return 1
	}

	l, r, res, sum := 0, 1, length+1, nums[0]

	for ; r < length; r++ {
		sum += nums[r]
		if sum >= s {
			for sum >= s {
				sum -= nums[l]
				l += 1
			}
			res = min(res, r-l+2)
		}
	}

	if res == length+1 {
		return 0
	}

	return res
}

func min(a, b int) int {
	if a < b {
		return a
	}

	return b
}
