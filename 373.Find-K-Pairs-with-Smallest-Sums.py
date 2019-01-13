# https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
#
# algorithms
# Medium (32.61%)
# Total Accepted:    55,423
# Total Submissions: 169,934
# beats 81.13% of python submissions


from heapq import heappush, heappop

class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        if k < 1:
            return []
        
        len1, len2 = len(nums1), len(nums2)
        if len1 == 0 or len2 == 0:
            return []
        
        heap = []
        for i in xrange(len1):
            heappush(heap, (nums1[i] + nums2[0], i, 0))
        
        res = []
        for _ in xrange(k):
            if len(heap) == 0:
                break
            s, idx1, idx2 = heappop(heap)
            res.append([nums1[idx1], nums2[idx2]])
            if idx2 < len2 - 1:
                idx2 += 1
                heappush(heap, (nums1[idx1] + nums2[idx2], idx1, idx2))

        return res
    