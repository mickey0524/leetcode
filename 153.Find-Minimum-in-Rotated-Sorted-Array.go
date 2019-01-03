// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//
// algorithms
// Medium (42.13%)
// Total Accepted:    245,488
// Total Submissions: 582,692
// beats 100.0% of golang submissions

package leetcode

func findMin(nums []int) int {
	length := len(nums)

	if length == 1 {
		return nums[0]
	}

	if nums[0] < nums[length-1] {
		return nums[0]
	}

	head, tail, middle := 0, length-1, -1
	for head < tail {
		middle = head + (tail-head)/2
		if nums[middle] >= nums[0] {
			head = middle + 1
		} else {
			tail = middle
		}
	}

	return nums[head]
}
