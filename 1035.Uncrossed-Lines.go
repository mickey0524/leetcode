// https://leetcode.com/problems/uncrossed-lines/
//
// algorithms
// Medium (40.19%)
// Total Accepted:    1,185
// Total Submissions: 2,948
// beats 100.0% of golang submissions

package leetcode

func maxUncrossedLines(A []int, B []int) int {
	lenA, lenB := len(A), len(B)

	dp := make([][]int, lenA+1)
	for i := 0; i < lenA+1; i++ {
		dp[i] = make([]int, lenB+1)
	}

	for i := 1; i <= lenA; i++ {
		for j := 1; j <= lenB; j++ {
			if A[i-1] == B[j-1] {
				dp[i][j] = max(dp[i-1][j-1]+1, dp[i-1][j], dp[i][j-1])
			} else {
				dp[i][j] = max(dp[i-1][j], dp[i][j-1])
			}
		}
	}

	return dp[lenA][lenB]
}

func max(nums ...int) int {
	res := nums[0]

	for _, n := range nums {
		if n > res {
			res = n
		}
	}

	return res
}
