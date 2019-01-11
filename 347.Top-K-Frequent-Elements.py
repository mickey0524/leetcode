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
        