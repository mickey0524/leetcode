// https://leetcode.com/problems/is-subsequence/description/
//
// algorithms
// Medium (45.38%)
// Total Accepted:    69.7K
// Total Submissions: 153.6K
// beats 100.0% of golang submissions

package leetcode

func isSubsequence(s string, t string) bool {
	if s == t || s == "" {
		return true
	}

	s_len, t_len := len(s), len(t)
	if s_len > t_len {
		return false
	}

	s_idx, t_idx := 0, 0

	for ; t_idx < t_len; t_idx++ {
		if t[t_idx] == s[s_idx] {
			s_idx++
			if s_idx == s_len {
				return true
			}
		}
	}

	return false
}
