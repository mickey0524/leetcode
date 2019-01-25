// https://leetcode.com/problems/find-and-replace-in-string/
//
// algorithms
// Medium (43.9%)
// Total Accepted:    12,793
// Total Submissions: 29,137
// beats 100.0% of golang submissions

package leetcode

import (
	"bytes"
	"sort"
)

type replace struct {
	index  int
	source string
	target string
}

func findReplaceString(S string, indexes []int, sources []string, targets []string) string {
	length := len(indexes)
	if length == 0 {
		return S
	}

	replaces := make([]replace, length)
	for i := 0; i < length; i++ {
		replaces[i] = replace{
			index:  indexes[i],
			source: sources[i],
			target: targets[i],
		}
	}

	sort.Slice(replaces, func(i, j int) bool {
		if replaces[i].index < replaces[j].index {
			return true
		}
		return false
	})

	res := bytes.NewBufferString("")
	preIdx := 0

	for _, r := range replaces {
		strLen := len(r.source)
		res.WriteString(S[preIdx:r.index])
		if S[r.index:r.index+strLen] == r.source {
			res.WriteString(r.target)
		} else {
			res.WriteString(S[r.index : r.index+strLen])
		}
		preIdx = r.index + strLen
	}

	res.WriteString(S[preIdx:])

	return res.String()
}
