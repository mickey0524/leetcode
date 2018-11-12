// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
//
// algorithms
// Medium (32.5%)
// Total Accepted:    324.5K
// Total Submissions: 1M
// beats 100.0% of golang submissions
// 如果没有rotate，直接binary search 即可，如果rotate，先找到旋转的位置，然后分左右binary search

package leetcode

func search(nums []int, target int) int {
	length := len(nums)
	if length == 0 || (length == 1 && nums[0] != target) {
		return -1
	}

	if nums[0] > nums[length-1] {
		head, tail, middle := 0, length-1, -1
		for {
			middle = head + (tail-head)/2
			if middle == length-1 || (nums[middle] < nums[middle+1] && nums[middle] < nums[middle-1]) {
				break
			} else if nums[middle] >= nums[0] {
				head = middle + 1
			} else if nums[middle] < nums[0] {
				tail = middle
			}
		}
		left, right := binarySearch(nums[:middle], target), binarySearch(nums[middle:], target)
		if left != -1 {
			return left
		} else if right != -1 {
			return right + middle
		}
		return -1
	}

	return binarySearch(nums, target)
}

func binarySearch(nums []int, target int) int {
	head, tail, middle := 0, len(nums)-1, -1

	for {
		if head > tail {
			break
		}
		middle = head + (tail-head)/2
		if nums[middle] == target {
			return middle
		} else if nums[middle] > target {
			tail = middle - 1
		} else {
			head = middle + 1
		}
	}

	return -1
}
