// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
//
// algorithms
// Medium (36.85%)
// Total Accepted:    35.3K
// Total Submissions: 95.8K
// beats 100.0% of golang submissions
// 这道题主要在于找到一定满足不了要求的节点，然后将s切割成一个个子串进行递归

package leetcode

import "sort"

func longestSubstring(s string, k int) int {
	length := len(s)
	if length < k {
		return 0
	}

	numMap := make(map[rune]int)
	arrMap := make(map[rune][]int)
	for idx, ch := range s {
		if v, ok := numMap[ch]; ok {
			numMap[ch] = v + 1
			arrMap[ch] = append(arrMap[ch], idx)
		} else {
			numMap[ch] = 1
			arrMap[ch] = []int{idx}
		}
	}

	idxArr := []int{-1}
	for ch, v := range numMap {
		if v < k {
			idxArr = append(idxArr, arrMap[ch]...)
		}
	}
	notMatchLen := len(idxArr)
	if notMatchLen == 1 {
		return length
	}
	idxArr = append(idxArr, length)
	sort.Sort(sort.IntSlice(idxArr))

	res := 0
	for i := 0; i < notMatchLen; i++ {
		tmp := longestSubstring(s[idxArr[i]+1:idxArr[i+1]], k)
		if tmp > res {
			res = tmp
		}
	}

	return res
}
