// https://leetcode.com/problems/add-binary/
//
// algorithms
// Easy (36.71%)
// Total Accepted:    252,250
// Total Submissions: 687,192
// beats 100.0% of golang submissions

package leetcode

import (
	"bytes"
	"strconv"
)

func addBinary(a string, b string) string {
	a, b = reverse(a), reverse(b)
	aLen, bLen := len(a), len(b)
	carry := 0
	res := bytes.NewBufferString("")

	for i := 0; i < min(aLen, bLen); i++ {
		cntBit := int((a[i]-48)+(b[i]-48)) + carry
		carry = cntBit / 2
		cntBit = cntBit % 2
		res.WriteString(strconv.Itoa(cntBit))
	}

	if aLen != bLen {
		idx := bLen
		length := aLen
		if aLen < bLen {
			a = b
			idx = aLen
			length = bLen
		}
		for i := idx; i < length; i++ {
			cntBit := int((a[i] - 48)) + carry
			carry = cntBit / 2
			cntBit = cntBit % 2
			res.WriteString(strconv.Itoa(cntBit))
			if carry == 0 {
				res.WriteString(a[i+1:])
				break
			}
		}
		if carry == 1 {
			res.WriteString("1")
		}
	} else if carry == 1 {
		res.WriteString("1")
	}

	return reverse(res.String())
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func reverse(s string) string {
	length := len(s)
	res := bytes.NewBufferString("")
	for i := length - 1; i >= 0; i-- {
		res.WriteByte(s[i])
	}

	return res.String()
}
