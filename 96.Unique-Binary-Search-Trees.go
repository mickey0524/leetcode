// https://leetcode.com/problems/evaluate-division/description/
//
// algorithms
// Medium (43.52%)
// Total Accepted:    167.5k
// Total Submissions: 384.9k
// beats 100.0% of golang submissions
// 这道题首先想到可以用递归分治的方法来做，将节点逐步分下去，最后逐个相乘得到结果

package leetcode

func numTrees(n int) int {
	return resursive(1, n)
}

func resursive(head, tail int) int {
	if tail <= head {
		return 1
	}

	res, mid := 0, head+(tail-head)/2

	for i := head; i <= mid; i++ {
		left := resursive(head, i-1)
		right := resursive(i+1, tail)
		if (tail-head)%2 == 0 && i == mid {
			res = res + left*right
		} else {
			res = res + 2*(left*right)
		}
	}

	return res
}

// 后来想想，这道题可以用dp的方法，其实从原理上来说和递归分治是相同的，只不过
// 递归是拆解，而dp直接相乘

func numTreesDP(n int) int {
	if n <= 1 {
		return 1
	}

	dp := make([]int, n+1)
	dp[0] = 1
	dp[1] = 1

	for i := 2; i <= n; i++ {
		for j := 0; j < i; j++ {
			dp[i] = dp[i] + dp[j]*dp[i-j-1]
		}
	}

	return dp[n]
}
