# https://leetcode.com/problems/best-sightseeing-pair/submissions/
# Medium (39.97%)
# Total Accepted:    2,616
# Total Submissions: 6,545
# beats 85.16% of python submissions


class Solution(object):
    def maxScoreSightseeingPair(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        res = -1
        cur_idx = 0
        length = len(A)

        for idx in xrange(1, length):
            n = A[idx]
            res = max(res, A[cur_idx] + n + cur_idx - idx)
            if n >= (cur_idx + A[cur_idx] - idx):
                cur_idx = idx

        return res
