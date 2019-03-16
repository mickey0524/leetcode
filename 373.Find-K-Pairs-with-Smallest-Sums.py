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

# 复习的时候我的解法，效率更高

from heapq import heappush, heappop


class Solution1(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        len_1, len_2 = len(nums1), len(nums2)

        if len_1 == 0 or len_2 == 0:
            return []

        h, res = [], []
        heappush(h, (nums1[0] + nums2[0], 0, 0))
        hash_map = {}

        for _ in xrange(min(k, len_1 * len_2)):
            if len(h) == 0:
                break
            s, idx_1, idx_2 = heappop(h)
            res += [nums1[idx_1], nums2[idx_2]],

            if idx_1 < len_1 - 1 and (idx_1 + 1, idx_2) not in hash_map:
                heappush(h, (nums1[idx_1 + 1] +
                             nums2[idx_2], idx_1 + 1, idx_2))
                hash_map[(idx_1 + 1, idx_2)] = True

            if idx_2 < len_2 - 1 and (idx_1, idx_2 + 1) not in hash_map:
                heappush(
                    h, (nums1[idx_1] + nums2[idx_2 + 1], idx_1, idx_2 + 1))
                hash_map[(idx_1, idx_2 + 1)] = True

        return res

    
