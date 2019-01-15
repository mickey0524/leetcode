// https://leetcode.com/problems/reverse-words-in-a-string-iii/
//
// algorithms
// Easy (62.57%)
// Total Accepted:    105,822
// Total Submissions: 169,122
// beats 100.0% of golang submissions

package leetcode

import "bytes"

func reverseWords(s string) string {
	length := len(s)

	if length == 0 {
		return s
	}

	res := bytes.NewBufferString("")
	prevIdx := 0
	for idx, n := range s {
		if n == ' ' {
			res.WriteString(reverseStr(s[prevIdx:idx]))
			res.WriteString(" ")
			prevIdx = idx + 1
		}
	}

	res.WriteString(reverseStr(s[prevIdx:]))

	return res.String()
}

func reverseStr(s string) string {
	res := []byte(s)

	head, tail := 0, len(res)-1
	for head < tail {
		res[head], res[tail] = res[tail], res[head]
		head++
		tail--
	}

	return string(res)
}
