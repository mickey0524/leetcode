// https://leetcode.com/problems/monotone-increasing-digits/
//
// algorithms
// Medium (41.17%)
// Total Accepted:    11,711
// Total Submissions: 28,462
// beats 100.0% of golang submissions

package leetcode

import "strconv"

func monotoneIncreasingDigits(N int) int {
	if N < 10 {
		return N
	}
	s := []byte(strconv.Itoa(N))
	length := len(s)
	i := 1

	for ; i < length; i++ {
		if s[i] < s[i-1] {
			break
		}
	}

	if i == length {
		return N
	}

	i--

	for ; i > 0; i-- {
		if s[i] > s[i-1] {
			break
		}
	}

	s[i]--
	for j := i + 1; j < length; j++ {
		s[j] = '0' + 9
	}

	res, _ := strconv.Atoi(string(s))

	return res
}
