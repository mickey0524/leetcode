// https://leetcode.com/problems/beautiful-arrangement-ii/
//
// algorithms
// Medium (51.26%)
// Total Accepted:    16,150
// Total Submissions: 31,505
// beats 100.0% of golang submissions

package leetcode

func constructArray(n int, k int) []int {
	head, tail := 1, 1+k
	var res []int

	for head <= tail {
		res = append(res, head)
		if tail > head {
			res = append(res, tail)
		}
		head++
		tail--
	}

	for i := k + 2; i <= n; i++ {
		res = append(res, i)
	}

	return res
}
