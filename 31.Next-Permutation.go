// https://leetcode.com/problems/next-permutation/
//
// algorithms
// Medium (29.7%)
// Total Accepted:    198,530
// Total Submissions: 668,444
// beats 100.0% of golang submissions

package leetcode

import "sort"

func nextPermutation(nums []int) {
	length := len(nums)
	if length == 1 {
		return
	}
	if nums[length-1] > nums[length-2] {
		nums[length-1], nums[length-2] = nums[length-2], nums[length-1]
		return
	}

	idx := length - 1
	for idx > 0 {
		if nums[idx] > nums[idx-1] {
			break
		}
		idx--
	}
	if idx == 0 {
		sort.Sort(sort.IntSlice(nums))
	} else {
		minNum, minIdx := nums[idx], idx

		for i := idx + 1; i < length; i++ {
			if nums[i] < minNum && nums[i] > nums[idx-1] {
				minNum = nums[i]
				minIdx = i
			}
		}

		nums[minIdx], nums[idx-1] = nums[idx-1], nums[minIdx]
		sort.Sort(sort.IntSlice(nums[idx:]))
	}
}
