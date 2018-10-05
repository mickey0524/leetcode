// https://leetcode.com/problems/string-compression/description/
//
// algorithms
// Easy (35.8%)
// Total Accepted:    29.7k
// Total Submissions: 82.9k
// beats 100.0% of golang submissions

package leetcode

import "strconv"

func compress(chars []byte) int {
	ch, num, idx := chars[0], 0, 0

	for _, char := range chars {
		if char == ch {
			num++
		} else {
			chars[idx] = ch
			idx++
			if num > 1 {
				for _, n := range strconv.Itoa(num) {
					chars[idx] = byte(n)
					idx++
				}
			}
			ch = char
			num = 1
		}
	}

	chars[idx] = ch
	idx++
	if num > 1 {
		for _, n := range strconv.Itoa(num) {
			chars[idx] = byte(n)
			idx++
		}
	}

	return len(chars[:idx])
}
