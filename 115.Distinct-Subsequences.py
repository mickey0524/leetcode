# https://leetcode.com/problems/distinct-subsequences/description/
#
# algorithms
# Hard (33.68%)
# Total Accepted:    94.5k
# Total Submissions: 280.6k
# beats 86.65% of python submissions


class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        if s == t:
            return 1

        s_len, t_len = len(s), len(t)

        if s_len <= t_len:
            return 0

        dp = [[0] * (s_len + 1) for _ in xrange(t_len + 1)]

        for i in xrange(s_len + 1):
            dp[0][i] = 1

        for i in xrange(1, t_len + 1):
            for j in xrange(1, s_len + 1):
                if s[j - 1] == t[i - 1]:
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]
                else:
                    dp[i][j] = dp[i][j - 1]

        return dp[t_len][s_len]
