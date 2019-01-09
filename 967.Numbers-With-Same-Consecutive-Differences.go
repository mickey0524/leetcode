// https://leetcode.com/problems/numbers-with-same-consecutive-differences/
//
// algorithms
// Medium (34.36%)
// Total Accepted:    3,759
// Total Submissions: 10,940
// beats 100.0% of golang submissions

package leetcode

import "strconv"

var res []int

func numsSameConsecDiff(N int, K int) []int {
	res = []int{}
	if N == 1 {
		res = append(res, 0)
	}

	for i := 1; i <= 9; i++ {
		resursive(1, N, K, strconv.Itoa(i))
	}

	return res
}

func resursive(idx, N, K int, path string) {
	if idx == N {
		resItem, _ := strconv.Atoi(path)
		res = append(res, resItem)
		return
	}

	lastBit := int(path[idx-1] - '0')
	head, tail := lastBit-K, lastBit+K
	if head >= 0 {
		resursive(idx+1, N, K, path+strconv.Itoa(head))
	}
	if tail != head && tail <= 9 {
		resursive(idx+1, N, K, path+strconv.Itoa(tail))
	}
}
