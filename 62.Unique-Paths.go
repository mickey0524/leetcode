// https://leetcode.com/problems/unique-paths/description/
//
// algorithms
// Medium (44.94%)
// Total Accepted:    231.4k
// Total Submissions: 514.9k
// beats 100.0% of golang submissions

package leetcode

func uniquePaths(m int, n int) int {
	if m*n == 0 {
		return 0
	}

	pathNum := make([][]int, n)
	for i := 0; i < n; i++ {
		pathNum[i] = make([]int, m)
	}

	for i := 0; i < n; i++ {
		for j := 0; j < m; j++ {
			if i == 0 && j == 0 {
				pathNum[i][j] = 1
			} else if i == 0 {
				pathNum[i][j] = pathNum[i][j-1]
			} else if j == 0 {
				pathNum[i][j] = pathNum[i-1][j]
			} else {
				pathNum[i][j] = pathNum[i-1][j] + pathNum[i][j-1]
			}
		}
	}

	return pathNum[n-1][m-1]
}
