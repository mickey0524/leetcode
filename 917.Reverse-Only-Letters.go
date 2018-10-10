// https://leetcode.com/problems/reverse-only-letters/description/
//
// algorithms
// Easy (58.82%)
// Total Accepted:    5k
// Total Submissions: 8.5k
// beats 100.0% of golang submissions

package leetcode

func reverseOnlyLetters(S string) string {
	tail := len(S) - 1
	byteS := []byte(S)

outer:
	for idx, ch := range byteS {
		if idx >= tail {
			break
		}
		if (ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90) {
			for {
				if (byteS[tail] >= 97 && byteS[tail] <= 122) || (byteS[tail] >= 65 && byteS[tail] <= 90) {
					byteS[idx] = byteS[tail]
					byteS[tail] = ch
					tail--
					break
				}
				tail--
				if tail == idx {
					break outer
				}
			}
		}
	}

	return string(byteS)
}
