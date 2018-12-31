// https://leetcode.com/problems/climbing-stairs/
//
// algorithms
// Easy (42.68%)
// Total Accepted:    326,903
// Total Submissions: 765,977
// beats 100.0% of golang submission

package leetcode

func climbStairs(n int) int {
	if n <= 2 {
		return n
	}

	dp := make([]int, n+1)
	dp[1] = 1
	dp[2] = 2

	for i := 3; i <= n; i++ {
		dp[i] = dp[i-1] + dp[i-2]
	}

	return dp[n]
}
