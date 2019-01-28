// https://leetcode.com/problems/string-without-aaa-or-bbb/
//
// algorithms
// Easy (29.30%)
// Total Accepted:    3,630
// Total Submissions: 12,101
// beats 100.0% of golang submissions

package leetcode

import (
	"bytes"
	"strings"
)

func strWithout3a3b(A int, B int) string {
	if A == B {
		res := bytes.NewBufferString("")
		for i := 0; i < A; i++ {
			res.WriteString("ab")
		}
		return res.String()
	}

	a, b := "a", "b"
	if A < B {
		A, B = B, A
		a, b = b, a
	}

	res := make([]string, 2*B+1)
	res[0] = a
	for i := 1; i < 2*B+1; i += 2 {
		res[i] = b
		res[i+1] = a
	}
	i := 0
	for j := 0; j < A-B-1; j++ {
		res[i] = res[i] + res[i]
		i += 2
	}

	return strings.Join(res, "")
}
