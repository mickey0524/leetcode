# https://leetcode.com/problems/4sum-ii/
#
# algorithms
# Medium (49.45%)
# Total Accepted:    54,219
# Total Submissions: 109,642
# beats 89.26% of python submissions

from collections import defaultdict

class Solution(object):
    def fourSumCount(self, A, B, C, D):
        """
        :type A: List[int]
        :type B: List[int]
        :type C: List[int]
        :type D: List[int]
        :rtype: int
        """
        hash_map_a_b = defaultdict(int)

        for idx_A, m in enumerate(A):
            for idx_B, n in enumerate(B):
                s = m + n
                hash_map_a_b[s] += 1

        res = 0

        for m in C:
            for n in D:
                s = m + n
                if -s in hash_map_a_b:
                    res += hash_map_a_b[-s]

        return res