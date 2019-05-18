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

var res string

func getPermutation1(n int, k int) string {
	if n == 1 {
		return "1"
	}

	res = ""
	curSum := 1
	var arr []int
	for i := 1; i <= n; i++ {
		curSum *= i
		arr = append(arr, i)
	}
	curSum /= n

	recursive(arr, k, n-1, curSum)

	return res
}

func recursive(arr []int, k, n, curSum int) {
	if n == 0 {
		res += strconv.Itoa(arr[0])
		return
	}
	idx := (k - 1) / curSum
	res += strconv.Itoa(arr[idx])
	tmp := append(arr[:idx:idx], arr[idx+1:]...)

	recursive(tmp, k-curSum*idx, n-1, curSum/n)
}
