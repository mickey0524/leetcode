// https://leetcode.com/problems/subarray-sum-equals-k/
//
// algorithms
// Medium (40.65%)
// Total Accepted:    62,991
// Total Submissions: 154,972

package leetcode

func subarraySum(nums []int, k int) int {
	length := len(nums)
	res := 0
	sumArr := make([]int, length)

	for i := 0; i < length; i++ {
		if nums[i] == k {
			res++
		}
		for j := 0; j < i; j++ {
			sumArr[j] += nums[i]
			if sumArr[j] == k {
				res++
			}

		}
		sumArr[i] = nums[i]
	}

	return res
}

// 这是最快的做法，用一个hashMap保存现有的和
// 如果sum - k存在于map中，则说明有一个子串和为k

func subarraySum(nums []int, k int) int {
	psum := map[int]int{0: 1}
	ans := 0
	for i, sum := 0, 0; i < len(nums); i++ {
		sum += nums[i]
		if cnt, ok := psum[sum-k]; ok {
			ans += cnt
		}
		psum[sum]++
	}

	return ans
}
