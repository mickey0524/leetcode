// https://leetcode.com/problems/substring-with-concatenation-of-all-words/
//
// algorithms
// Medium (23.27%)
// Total Accepted:    125,993
// Total Submissions: 541,383
// beats 71.43% of golang submissions

package leetcode

func findSubstring(s string, words []string) []int {
	length := len(words)
	if length == 0 {
		return []int{}
	}

	wLen := len(words[0])
	sLen := len(s)

	if wLen*length > sLen {
		return []int{}
	}

	hashMap := make(map[string]int)

	for _, w := range words {
		if v, exist := hashMap[w]; exist {
			hashMap[w] = v + 1
		} else {
			hashMap[w] = 1
		}
	}

	m := cloneMap(hashMap)
	var res []int

	for i := 0; i <= sLen-wLen*length; i++ {
		if v, exist := m[s[i:i+wLen]]; exist && v > 0 {
			m[s[i:i+wLen]] = v - 1
			j := 1
			for ; j < length; j++ {
				idx := i + wLen*j
				if innerV, innerExist := m[s[idx:idx+wLen]]; innerExist && innerV > 0 {
					m[s[idx:idx+wLen]] = innerV - 1
				} else {
					break
				}
			}
			if j == length {
				res = append(res, i)
			}
			m = cloneMap(hashMap)
		}
	}

	return res
}

func cloneMap(hashMap map[string]int) map[string]int {
	r := make(map[string]int)

	for k, v := range hashMap {
		r[k] = v
	}

	return r
}
