// https://leetcode.com/problems/longest-repeating-character-replacement/
//
// algorithms
// Medium (43.16%)
// Total Accepted:    24,824
// Total Submissions: 57,513
// 我的做法就不聊了，看完 100% 的做法觉得贼愚蠢

package leetcode

type repeatSubStr struct {
	beginIdx int
	endIdx   int
}

func characterReplacement(s string, k int) int {
	length := len(s)
	if length < 2 || k >= length {
		return length
	}

	hashMap := make(map[byte][]repeatSubStr)

	cntCh, cntIdx := s[0], 0
	for i := 1; i < length; i++ {
		if s[i] == cntCh {
			continue
		} else {
			if _, ok := hashMap[cntCh]; ok {
				hashMap[cntCh] = append(hashMap[cntCh], repeatSubStr{cntIdx, i - 1})
			} else {
				hashMap[cntCh] = []repeatSubStr{{cntIdx, i - 1}}
			}
			cntCh = s[i]
			cntIdx = i
		}
	}
	if _, ok := hashMap[cntCh]; ok {
		hashMap[cntCh] = append(hashMap[cntCh], repeatSubStr{cntIdx, length - 1})
	} else {
		hashMap[cntCh] = []repeatSubStr{{cntIdx, length - 1}}
	}

	res := 0

	for _, arr := range hashMap {
		arrLen := len(arr)
		tmp := arr[0].endIdx - arr[0].beginIdx + 1
		if arrLen == 1 {
			res = max(res, tmp+k)
		}
		cntK := k
		head, tail := 0, 1
		for tail < arrLen {
			tailGap := arr[tail].beginIdx - arr[tail-1].endIdx - 1
			if cntK >= tailGap {
				tmp += tailGap + arr[tail].endIdx - arr[tail].beginIdx + 1
				cntK -= tailGap
				tail++
			} else if tail-head == 1 {
				res = max(res, tmp+cntK)
				tmp = arr[tail].endIdx - arr[tail].beginIdx + 1
				head++
				tail++
			} else {
				headGap := arr[head+1].beginIdx - arr[head].endIdx - 1
				cntK += headGap
				tmp -= arr[head+1].beginIdx - arr[head].beginIdx
				head++
			}
			res = max(res, tmp+cntK)
		}
	}

	if res > length {
		res = length
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// 这是 100% 的做法

func characterReplacement(s string, k int) int {
	n := len(s)
	if n == 0 {
		return 0
	}

	begin := 0
	charCounts := make([]int, 26)
	maxCharCount := 0

	var ret int

	for end := 0; end < n; end++ {
		c := s[end]
		charCounts[c-'A']++
		if charCounts[c-'A'] > maxCharCount {
			maxCharCount = charCounts[c-'A']
		}

		for end-begin+1-maxCharCount > k {
			charCounts[s[begin]-'A']--
			begin++
		}
		if end-begin+1 > ret {
			ret = end - begin + 1
		}

	}

	return ret
}
