// https://leetcode.com/problems/coin-change/
//
// algorithms
// Medium (30.09%)
// Total Accepted:    188,159
// Total Submissions: 625,420

package leetcode

var MAX_INT = 1<<31 - 1

func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	for i := 1; i <= amount; i++ {
		dp[i] = MAX_INT
	}

	for i := 0; i < amount; i++ {
		for _, c := range coins {
			if i+c <= amount && dp[i]+1 < dp[i+c] {
				dp[i+c] = dp[i] + 1
			}
		}
	}

	if dp[amount] == MAX_INT {
		return -1
	}

	return dp[amount]
}
