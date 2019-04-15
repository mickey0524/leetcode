# https://leetcode.com/problems/longest-arithmetic-sequence/
# Medium (41.35%)
# Total Accepted:    2,953
# Total Submissions: 7,141
# beats 100.0% of python submissions


class Solution(object):
    def longestArithSeqLength(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        length = len(A)
        if length < 3:
            return length
        
        dp = [{} for _ in xrange(length)]
        res = 2
        
        for i in xrange(1, length):
            for j in xrange(i):
                diff = A[i] - A[j]
                tmp = 1 + dp[j][diff] if diff in dp[j] else 2
                dp[i][diff] = tmp if diff not in dp[i] else max(dp[i][diff], tmp)
                res = max(res, dp[i][diff])
        
        return res
                