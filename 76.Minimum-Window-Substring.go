// https://leetcode.com/problems/minimum-window-substring/
//
// algorithms
// Hard (30.95%)
// Total Accepted:    241,120
// Total Submissions: 779,174

package leetcode

func minWindow(s string, t string) string {
	lenS, lenT := len(s), len(t)
	if lenS < lenT {
		return ""
	}

	mapT := make(map[byte]int)
	mapS := make(map[byte]int)
	for i := 0; i < lenT; i++ {
		if v, exist := mapT[t[i]]; exist {
			mapT[t[i]] = v + 1
		} else {
			mapT[t[i]] = 1
		}
	}

	l, r, res := 0, 0, ""

	for ; r < lenS; r++ {
		if v, exist := mapS[s[r]]; exist {
			mapS[s[r]] = v + 1
		} else {
			mapS[s[r]] = 1
		}

		if compare(mapS, mapT) {
			if res == "" || (r-l+1) < len(res) {
				res = s[l : r+1]
			}
			for l < r {
				mapS[s[l]]--
				l++
				if _, ok := mapT[s[l-1]]; ok && mapT[s[l-1]] > mapS[s[l-1]] {
					break
				}
				if (r - l + 1) < len(res) {
					res = s[l : r+1]
				}
			}
		}
	}

	return res
}

func compare(mapS, mapT map[byte]int) bool {
	for k, v1 := range mapT {
		if v2, exist := mapS[k]; exist {
			if v2 < v1 {
				return false
			}
		} else {
			return false
		}
	}

	return true
}
