// https://leetcode.com/problems/partition-array-for-maximum-sum/
//
// algorithms
// Easy (60.21%)
// Total Accepted:    4,581
// Total Submissions: 7,608
// beats 100.0% of golang submissions

package leetcode

import "bytes"

func removeDuplicates(S string) string {
	length := len(S)
	if length < 2 {
		return S
	}

	var stack []byte

	for i := 0; i < length; i++ {
		stackLen := len(stack)
		if stackLen != 0 {
			if stack[stackLen-1] == S[i] {
				stack = stack[:stackLen-1]
			} else {
				stack = append(stack, S[i])
			}
		} else {
			stack = append(stack, S[i])
		}
	}

	bs := bytes.NewBufferString("")
	for i := 0; i < len(stack); i++ {
		bs.WriteByte(stack[i])
	}

	return bs.String()
}
