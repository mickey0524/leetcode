# https://leetcode.com/problems/monotonic-array/description/
#
# algorithms
# Medium (11.97%)
# Total Accepted:    766
# Total Submissions: 6.4k


class Solution(object):
    def smallestRangeII(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        length = len(A)

        if length == 1:
            return 0

        A.sort()

        res = A[-1] - A[0]
        top = A[-1] - K
        bottom = A[0] + K

        for i in xrange(length - 1):
            top = max(A[-1] - K, A[i] + K)
            bottom = min(A[0] + K, A[i + 1] - K)
            res = min(res, top - bottom)

        return res
