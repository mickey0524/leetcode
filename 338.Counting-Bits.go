// https://leetcode.com/problems/counting-bits/
//
// algorithms
// Medium (63.92%)
// Total Accepted:    151,892
// Total Submissions: 237,627
// beats 100.0% of golang submissions

package leetcode

func countBits(num int) []int {
	res := make([]int, num+1)

	for i := 1; i <= num; i++ {
		res[i] = res[i&(i-1)] + 1
	}

	return res
}
