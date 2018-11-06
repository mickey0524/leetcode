// https://leetcode.com/problems/longest-palindromic-substring/description/
//
// algorithms
// Medium (25.04%)
// Total Accepted:    400.7k
// Total Submissions: 1.6m
// beats 67.21% of golang submissions

package leetcode

func longestPalindrome(s string) string {
	length := len(s)

	if length < 2 {
		return s
	}

	maxLen, res := 1, string(s[0])

	for idx := 0; idx < length; idx++ {
		odd, even := 0, 0
		for {
			if idx-odd < 0 || idx+odd == length {
				break
			}
			if s[idx-odd] != s[idx+odd] {
				break
			}
			odd++
		}
		if 2*(odd-1)+1 > maxLen {
			res = s[idx-odd+1 : idx+odd]
			maxLen = 2*(odd-1) + 1
		}

		for {
			if idx-even < 0 || idx+even+1 == length {
				break
			}
			if s[idx-even] != s[idx+even+1] {
				break
			}
			even++
		}
		if even > 0 && 2*even > maxLen {
			res = s[idx-even+1 : idx+even+1]
			maxLen = 2 * even
		}
	}

	return res
}
