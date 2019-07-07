# https://leetcode.com/problems/regular-expression-matching/
#
# algorithms
# Hard (25.4%)
# Total Accepted:    315,936
# Total Submissions: 1,243,801


class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        s_len, p_len = len(s), len(p)
        dp = [[False] * (p_len + 1) for _ in xrange(s_len + 1)]

        dp[0][0] = True
        for i in xrange(2, p_len + 1):
            if p[i - 1] == '*' and dp[0][i - 2]:
                dp[0][i] = True

        for i in xrange(s_len):
            for j in xrange(p_len):
                if s[i] == p[j] or p[j] == '.':
                    dp[i + 1][j + 1] = dp[i][j]

                elif p[j] == '*':
                    if p[j - 1] == s[i] or p[j - 1] == '.':
                        dp[i + 1][j + 1] = dp[i + 1][j -
                                                     1] or dp[i + 1][j] or dp[i][j + 1]
                    else:
                        dp[i + 1][j + 1] = dp[i + 1][j - 1]

        return dp[s_len][p_len]
