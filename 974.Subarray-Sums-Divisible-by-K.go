// https://leetcode.com/problems/subarray-sums-divisible-by-k/
//
// algorithms
// Medium (35.74%)
// Total Accepted:    3,129
// Total Submissions: 8,755
// beats 100.0% of golang submissions
// 这道题的思路是记录每一种余数的总数，例如 2 这个余数
// 假设索引下标 0 - 2, 0 - 4, 0 - 6 remainder 都是 2
// 那么 3 - 4, 5 - 6, 3 - 6 相加余数都是 0
// (1 + n - 1) * (n - 1) / 2

package leetcode

func subarraysDivByK(A []int, K int) int {
	length := len(A)
	if length == 0 {
		return 0
	}

	remainder := make([]int, K)
	remainder[0] = 1
	sums := 0
	for _, n := range A {
		sums += n
		remainder[sums%K]++
	}

	res := 0
	for _, n := range remainder {
		res += (n * (n - 1)) / 2
	}

	return res
}
