# https://leetcode.com/problems/ones-and-zeroes/
#
# algorithms
# Medium (39.4%)
# Total Accepted:    28,841
# Total Submissions: 73,199


class Solution(object):
    def findMaxForm(self, strs, m, n):
        """
        :type strs: List[str]
        :type m: int
        :type n: int
        :rtype: int
        """
        length = len(strs)

        dp = [[0] * (n + 1) for _ in xrange(m + 1)]

        for s in strs:
            ones, zeros = 0, 0
            for ch in s:
                if ch == '0':
                    zeros += 1
                else:
                    ones += 1

            for i in xrange(m, zeros - 1, -1):
                for j in xrange(n, ones - 1, -1):
                    dp[i][j] = max(dp[i][j], dp[i - zeros][j - ones] + 1)

        return dp[m][n]
