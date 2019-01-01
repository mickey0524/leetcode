// https://leetcode.com/problems/merge-sorted-array/
//
// algorithms
// Easy (34.21%)
// Total Accepted:    306,449
// Total Submissions: 895,894
// beats 100.0% of golang submissions

package leetcode

func merge(nums1 []int, m int, nums2 []int, n int) {
	for idx, target := range nums2 {
		insertIdx := binaryInsert(nums1, idx+m, target)
		for i := idx + m - 1; i >= insertIdx; i-- {
			nums1[i+1] = nums1[i]
		}
		nums1[insertIdx] = target
	}
}

func binaryInsert(nums1 []int, tail, target int) int {
	head, middle := 0, -1

	for head < tail {
		middle = head + (tail-head)/2
		if nums1[middle] > target {
			tail = middle
		} else if nums1[middle] < target {
			head = middle + 1
		} else {
			return middle
		}
	}

	return tail
}
