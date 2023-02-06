// https://leetcode.com/problems/minimum-common-value/description/
// Easy (53.2%)
// Total Accepted: 24.2K
// Total Submissions: 45.6K

package leetcode

func getCommon(nums1 []int, nums2 []int) int {
	len1, len2 := len(nums1), len(nums2)
	var idx1, idx2 int

	for idx1 < len1 && idx2 < len2 {
		if nums1[idx1] == nums2[idx2] {
			return nums1[idx1]
		} else if nums1[idx1] > nums2[idx2] {
			idx2++
		} else {
			idx1++
		}
	}

	return -1
}