// https://leetcode.com/problems/house-robber/
//
// algorithms
// Medium (40.59%)
// Total Accepted:    270,265
// Total Submissions: 665,678
// beats 100.0% of golang submissions

package leetcode

func rob(nums []int) int {
	length := len(nums)

	if length == 0 {
		return 0
	}
	if length == 1 {
		return nums[0]
	}

	dp := make([]int, length+1)

	dp[1] = nums[0]

	for i := 1; i < length; i++ {
		dp[i+1] = max(dp[i-1]+nums[i], dp[i])
	}

	return dp[length]
}

func max(a, b int) int {
	if a < b {
		return b
	}
	return a
}
