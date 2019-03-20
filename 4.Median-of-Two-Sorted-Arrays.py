# https://leetcode.com/problems/median-of-two-sorted-arrays/
#
# algorithms
# Medium (25.73%)
# Total Accepted:    396,749
# Total Submissions: 1,542,138


class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        def merge_sort(k):
            cur_k = 0
            idx1, idx2 = 0, 0

            while idx1 < len1 and idx2 < len2:
                cur_k += 1
                if nums1[idx1] <= nums2[idx2]:
                    if cur_k == k:
                        return nums1[idx1]
                    idx1 += 1
                else:
                    if cur_k == k:
                        return nums2[idx2]
                    idx2 += 1

            if idx1 < len1:
                return nums1[idx1 + (k - cur_k - 1)]

            return nums2[idx2 + (k - cur_k - 1)]

        len1, len2 = len(nums1), len(nums2)
        length = len1 + len2

        if length % 2 == 1:
            return merge_sort(length / 2 + 1)
        else:
            smaller = merge_sort(length / 2)
            bigger = merge_sort(length / 2 + 1)

            return (smaller + bigger) / 2.0
