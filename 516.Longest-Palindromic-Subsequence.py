# https://leetcode.com/problems/coin-change-2/
#
# algorithms
# Medium (48.27%)
# Total Accepted:    71,661
# Total Submissions: 148,458


class Solution(object):
    def longestPalindromeSubseq(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = len(s)
        if length == 0:
            return 0

        dp = [[0] * length for _ in xrange(length)]
        for i in xrange(length):
            dp[i][i] = 1

        for i in xrange(length):
            for j in xrange(i - 1, -1, -1):
                if s[i] == s[j]:
                    dp[j][i] = dp[j + 1][i - 1] + 2
                else:
                    dp[j][i] = max(dp[j + 1][i], dp[j][i - 1])

        return dp[0][length - 1]
