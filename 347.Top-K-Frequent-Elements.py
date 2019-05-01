# https://leetcode.com/problems/top-k-frequent-elements/
#
# algorithms
# Medium (52.46%)
# Total Accepted:    161,716
# Total Submissions: 308,275

from collections import Counter

class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        counter = Counter(nums)
        return [x[0] for x in counter.most_common(k)]


from heapq import heappush, heappop


class Solution1(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        hash_map = {}
        for n in nums:
            hash_map[n] = hash_map.get(n, 0) + 1

        h = []

        for key, v in hash_map.iteritems():
            heappush(h, (-v, key))

        res = []

        for _ in xrange(k):
            res.append(heappop(h)[1])

        return res
        
