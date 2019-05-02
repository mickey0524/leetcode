// https://leetcode.com/problems/perfect-squares/
//
// algorithms
// Medium (41.65%)
// Total Accepted:    176,708
// Total Submissions: 424,280

package leetcode

func numSquares(n int) int {
	var squares []int
	idx := 1

	for {
		tmp := idx * idx
		if tmp == n {
			return 1
		}
		if tmp > n {
			break
		}
		squares = append([]int{tmp}, squares...)
		idx++
	}

	dp := make([]int, n+1)
	for _, s := range squares {
		dp[s] = 1
	}

	for i := 1; i < n; i++ {
		for _, s := range squares {
			if i+s <= n {
				if dp[i+s] == 0 {
					dp[i+s] = 1 + dp[i]
				} else {
					dp[i+s] = min(dp[i+s], 1+dp[i])
				}
			}
		}
	}

	return dp[n]
}

func min(a, b int) int {
	if a < b {
		return a
	}

	return b
}
