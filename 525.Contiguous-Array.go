// https://leetcode.com/problems/contiguous-array/
//
// algorithms
// Medium (42.33%)
// Total Accepted:    35,708
// Total Submissions: 84,361
// beats 100.0% of golang submissions

package leetcode

func findMaxLength(nums []int) int {
	diff := 0
	res := 0
	hashMap := make(map[int]int)
	hashMap[0] = 0

	for idx, n := range nums {
		if n == 0 {
			diff++
		} else {
			diff--
		}
		if preIdx, ok := hashMap[diff]; ok {
			res = max(res, idx-preIdx+1)
		} else {
			hashMap[diff] = idx + 1
		}
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
