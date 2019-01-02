// https://leetcode.com/problems/permutation-sequence/
//
// algorithms
// Medium (31.55%)
// Total Accepted:    122,809
// Total Submissions: 389,241
// beats 100.0% of golang submissions

package leetcode

import "strconv"

func getPermutation(n int, k int) string {
	var nums []int
	for i := 1; i <= n; i++ {
		nums = append(nums, i)
	}

	return resursive(nums, k)
}

func resursive(nums []int, k int) string {
	length := len(nums)
	if length == 0 {
		return ""
	}

	factorialN := factorial(length - 1)
	idx := k / factorialN
	remainder := k % factorialN

	if remainder == 0 {
		idx--
	}

	nextNums := make([]int, length)
	copy(nextNums, nums)
	nextNums = append(nextNums[:idx], nextNums[idx+1:]...)

	return strconv.Itoa(nums[idx]) + resursive(nextNums, k-idx*factorialN)
}

func factorial(n int) int {
	res := 1

	for i := 1; i <= n; i++ {
		res *= i
	}

	return res
}
