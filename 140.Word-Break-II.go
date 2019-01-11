// https://leetcode.com/problems/word-break-ii/
//
// algorithms
// Hard (26.26%)
// Total Accepted:    141,443
// Total Submissions: 538,582
// beats 100.0% of golang submissions

package leetcode

import "strings"

var hashMap map[string][]string

func wordBreak(s string, wordDict []string) []string {
	hashMap = make(map[string][]string)

	return DFS(s, wordDict)
}

func DFS(s string, wordDict []string) []string {
	if arr, ok := hashMap[s]; ok {
		return arr
	}

	var res []string

	if len(s) == 0 {
		res = append(res, "")
		return res
	}

	for _, word := range wordDict {
		if strings.HasPrefix(s, word) {
			subArr := DFS(s[len(word):], wordDict)
			for _, s := range subArr {
				if s == "" {
					res = append(res, word)
				} else {
					res = append(res, word+" "+s)
				}
			}
		}
	}

	hashMap[s] = res
	return res
}
