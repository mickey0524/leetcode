# https://leetcode.com/problems/gray-code/
#
# algorithms
# Easy (35.75%)
# Total Accepted:    365,649
# Total Submissions: 1,022,741
# beats 95.52% of python submissions


class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        while m and n:
            if nums1[m - 1] > nums2[n - 1]:
                nums1[m + n - 1] = nums1[m - 1]
                m -= 1
            else:
                nums1[m + n - 1] = nums2[n - 1]
                n -= 1

        nums1[:n] = nums2[:n]

        return nums1
