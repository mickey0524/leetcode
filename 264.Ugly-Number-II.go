// https://leetcode.com/problems/ugly-number-ii/
//
// algorithms
// Medium (35.55%)
// Total Accepted:    96,846
// Total Submissions: 272,438
// beats 100.0% of golang submissions

package leetcode

func nthUglyNumber(n int) int {
	nums := []int{1}
	idx_2, idx_3, idx_5 := 0, 0, 0
	var curMin int

	for i := 1; i < n; i++ {
		base_2, base_3, base_5 := nums[idx_2]*2, nums[idx_3]*3, nums[idx_5]*5
		curMin = min(base_2, base_3, base_5)
		nums = append(nums, curMin)
		if base_2 <= curMin {
			idx_2++
		}
		if base_3 <= curMin {
			idx_3++
		}
		if base_5 <= curMin {
			idx_5++
		}
	}

	return nums[n-1]
}

func min(nums ...int) int {
	curMin := nums[0]

	for i := 1; i < len(nums); i++ {
		if nums[i] < curMin {
			curMin = nums[i]
		}
	}

	return curMin
}
