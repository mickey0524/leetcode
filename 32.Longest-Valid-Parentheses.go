// https://leetcode.com/problems/longest-valid-parentheses/description/
//
// algorithms
// Hard (24.14%)
// Total Accepted:    153.7k
// Total Submissions: 636.8k
// beats 56.25% of golang submissions
// 分两种情况讨论，res[i - 1] = 0代表前一位没匹配上，这时候只有'()'是合法的
// 当res[i - 1] > 0的时候，看两端是否为'()'
// 最后查看当前合法串的前方是否为合法的，是的话相加

package leetcode

func longestValidParentheses(s string) int {
	length := len(s)

	res := make([]int, length)
	maxLen := 0

	for i := 1; i < length; i++ {
		if res[i-1] == 0 {
			if s[i-1] == '(' && s[i] == ')' {
				res[i] = 2
			} else {
				res[i] = 0
			}
		} else {
			leftIdx := i - 1 - res[i-1]
			if leftIdx >= 0 && s[leftIdx] == '(' && s[i] == ')' {
				res[i] = 2 + res[i-1]
			} else {
				res[i] = 0
			}
		}
		if res[i] > 0 && i-res[i] >= 0 && res[i-res[i]] > 0 {
			res[i] += res[i-res[i]]
		}
		if res[i] > maxLen {
			maxLen = res[i]
		}
	}

	return maxLen
}
