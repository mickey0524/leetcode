// https://leetcode.com/problems/camelcase-matching/
//
// algorithms
// Medium (58.14%)
// Total Accepted:    3,358
// Total Submissions: 5,776
// beats 100.0% of golang submissions

package leetcode

func camelMatch(queries []string, pattern string) []bool {
	queryLen := len(queries)

	res := make([]bool, queryLen)

	for i := 0; i < queryLen; i++ {
		res[i] = isMatch(queries[i], pattern)
	}

	return res
}

func isMatch(word, pattern string) bool {
	wLen, pLen := len(word), len(pattern)
	if wLen < pLen {
		return false
	}

	wIdx, pIdx := 0, 0
	for pIdx < pLen && wIdx < wLen {
		pIsUpper := isUpperCase(pattern[pIdx])
		for wIdx < wLen && word[wIdx] != pattern[pIdx] {
			if pIsUpper && isUpperCase(word[wIdx]) {
				return false
			}
			wIdx++
		}
		pIdx++
		wIdx++
	}
	for wIdx < wLen && !isUpperCase(word[wIdx]) {
		wIdx++
	}

	if wIdx == wLen {
		return true
	}

	return false
}

func isUpperCase(ch byte) bool {
	if ch <= 90 {
		return true
	}
	return false
}
