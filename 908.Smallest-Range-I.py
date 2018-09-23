# https://leetcode.com/problems/monotonic-array/description/
#
# algorithms
# Easy (65.12%)
# Total Accepted:    2.8k
# Total Submissions: 4.3k


class Solution(object):
    def smallestRangeI(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        if len(A) == 1:
            return 0

        diff = max(A) - min(A)

        return 0 if diff <= 2 * K else diff - 2 * K
