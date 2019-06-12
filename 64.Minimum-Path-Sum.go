// https://leetcode.com/problems/minimum-path-sum/
//
// algorithms
// Medium (47.07%)
// Total Accepted:    233,578
// Total Submissions: 496,276
// beats 100.0% of golang submissions

package leetcode

func minPathSum(grid [][]int) int {
	row := len(grid)
	if row == 0 {
		return 0
	}
	col := len(grid[0])

	dp := make([][]int, row)
	for i := 0; i < row; i++ {
		dp[i] = make([]int, col)
	}

	dp[0][0] = grid[0][0]
	for i := 1; i < col; i++ {
		dp[0][i] = dp[0][i-1] + grid[0][i]
	}
	for i := 1; i < row; i++ {
		dp[i][0] = dp[i-1][0] + grid[i][0]
	}

	for i := 1; i < row; i++ {
		for j := 1; j < col; j++ {
			dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
		}
	}

	return dp[row-1][col-1]
}

func min(a, b int) int {
	if a < b {
		return a
	}

	return b
}
