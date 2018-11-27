// https://leetcode.com/problems/word-subsets/description/
//
// algorithms
// Medium (42.96%)
// Total Accepted:    5.8k
// Total Submissions: 13.5k

package leetcode

func wordSubsets(A []string, B []string) []string {
	res := []string{}

	bMap := make(map[rune]int)

	for _, s := range B {
		tmp := make(map[rune]int)
		for _, ch := range s {
			if v, ok := tmp[ch]; ok {
				tmp[ch] = v + 1
			} else {
				tmp[ch] = 1
			}
		}
		for k, v := range tmp {
			bV, ok := bMap[k]
			if !ok {
				bMap[k] = v
			} else if v > bV {
				bMap[k] = v
			}
		}
	}

	for _, s := range A {
		sMap := make(map[rune]int)
		for k, v := range bMap {
			sMap[k] = v
		}
		for _, ch := range s {
			if v, ok := sMap[ch]; ok {
				if v == 1 {
					delete(sMap, ch)
				} else {
					sMap[ch] = v - 1
				}
			}
		}
		if len(sMap) == 0 {
			res = append(res, s)
		}
	}

	return res
}
