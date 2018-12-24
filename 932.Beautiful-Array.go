// https://leetcode.com/problems/beautiful-array/
//
// algorithms
// Medium (48.4%)
// Total Accepted:    2,651
// Total Submissions: 5,477
// 思路是分治法，2 * N 肯定是偶数，那么一边放奇数，一边放偶数肯定符合要求
// N 的话，奇数有 N + 1 / 2个，偶数有 N / 2 个，分治就能得到最后的结果

package leetcode

func beautifulArray(N int) []int {
	res := []int{}

	if N == 1 {
		res = append(res, N)
	} else {
		odd := beautifulArray((N + 1) / 2)
		for _, n := range odd {
			res = append(res, n*2-1)
		}
		even := beautifulArray(N / 2)
		for _, n := range even {
			res = append(res, n*2)
		}
	}

	return res
}
