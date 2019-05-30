// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//
// algorithms
// Easy (40.71%)
// Total Accepted:    592,497
// Total Submissions: 1,455,584
// beats 100.0% of golang submissions

package leetcode

func removeDuplicates(nums []int) int {
	length := len(nums)

	if length < 2 {
		return length
	}

	count := 0

	for i := 1; i < length; i++ {
		if nums[i] != nums[count] {
			count++
			nums[count] = nums[i]
		}
	}

	return count + 1
}
