// https://leetcode.com/problems/partition-array-for-maximum-sum/
//
// algorithms
// Medium (49.79%)
// Total Accepted:    1,110
// Total Submissions: 2,229
// beats 100.0% of golang submissions

package leetcode

func maxSumAfterPartitioning(A []int, K int) int {
	length := len(A)
	dp := make([]int, length+1)

	for i := 1; i <= length; i++ {
		dp[i] = A[i-1]
	}

	for i := 1; i <= length; i++ {
		for j := max(0, i-K); j < i; j++ {
			curMax := A[j]
			for k := j + 1; k <= i; k++ {
				curMax = max(curMax, A[k-1])
			}
			dp[i] = max(dp[i], dp[j]+curMax*(i-j))
		}
	}

	return dp[length]
}

func max(a, b int) int {
	if a > b {
		return a
	}

	return b
}
