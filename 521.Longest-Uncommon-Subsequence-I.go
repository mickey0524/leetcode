// https://leetcode.com/problems/longest-uncommon-subsequence-i/
//
// algorithms
// Easy (55.97%)
// Total Accepted:    42,343
// Total Submissions: 75,651
// beats 100.0% of golang submissions
// 无聊透顶的题目
package leetcode

func findLUSlength(a string, b string) int {
	if a == b {
		return -1
	}
	return max(len(a), len(b))
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
