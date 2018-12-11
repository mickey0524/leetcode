// https://leetcode.com/problems/verifying-an-alien-dictionary/
//
// algorithms
// Easy (59.39%)
// Total Accepted:    3,534
// Total Submissions: 5,950
// beats 100.0% of golang submissions

package leetcode

func isAlienSorted(words []string, order string) bool {
	alphabet := make(map[rune]int)

	for idx, ch := range order {
		alphabet[ch] = idx
	}

resursive:
	for idx, word := range words[1:] {
		preWord := words[idx]
		cntWordLen, preWordLen := len(word), len(preWord)
		length := min(cntWordLen, preWordLen)
		for i := 0; i < length; i++ {
			if alphabet[rune(word[i])] < alphabet[rune(preWord[i])] {
				return false
			} else if alphabet[rune(word[i])] > alphabet[rune(preWord[i])] {
				continue resursive
			}
		}
		if cntWordLen < preWordLen {
			return false
		}
	}

	return true
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
