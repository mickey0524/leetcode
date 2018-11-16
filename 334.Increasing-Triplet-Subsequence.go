// https://leetcode.com/problems/increasing-triplet-subsequence/description/
//
// algorithms
// Medium (39.29%)
// Total Accepted:    76.3K
// Total Submissions: 194.2K
// beats 100.0% of golang submissions

package leetcode

func increasingTriplet(nums []int) bool {
	length := len(nums)

	if length < 3 {
		return false
	}

	leftLess := make([]bool, length)
	minN := nums[0]
	for i := 1; i < length; i++ {
		if nums[i] > minN {
			leftLess[i] = true
		} else if nums[i] < minN {
			minN = nums[i]
		}
	}

	rightMore := make([]bool, length)
	maxN := nums[length-1]
	for i := length - 2; i >= 0; i-- {
		if nums[i] < maxN {
			rightMore[i] = true
		} else if nums[i] > maxN {
			maxN = nums[i]
		}
	}

	for i := 0; i < length; i++ {
		if leftLess[i] && rightMore[i] {
			return true
		}
	}

	return false
}
