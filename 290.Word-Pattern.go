// https://leetcode.com/problems/increasing-triplet-subsequence/description/
//
// algorithms
// Medium (34.34%)
// Total Accepted:    126,215
// Total Submissions: 367,525
// beats 100.0% of golang submissions

package leetcode

import "strings"

func wordPattern(pattern string, str string) bool {
	strMap := make(map[string]byte)
	patternMap := make(map[byte]string)

	strArr := strings.Fields(str)

	if len(pattern) != len(strArr) {
		return false
	}

	for idx, s := range strArr {
		_, strExist := strMap[s]
		_, patternExist := patternMap[pattern[idx]]
		if !strExist && !patternExist {
			strMap[s] = pattern[idx]
			patternMap[pattern[idx]] = s
		} else if patternExist && strExist {
			if strMap[s] != pattern[idx] || patternMap[pattern[idx]] != s {
				return false
			}
		} else {
			return false
		}
	}

	return true
}
