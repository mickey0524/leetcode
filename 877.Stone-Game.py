# https://leetcode.com/problems/stone-game/description/
#
# algorithms
# Medium (52.4%)
# Total Accepted:    4.3k
# Total Submissions: 8.2k
# beats 42.36% of python submissions

class Solution(object):
    def stoneGame(self, piles):
        """
        :type piles: List[int]
        :rtype: bool
        """
        length = len(piles)
        dp = [[0] * length for _ in xrange(length)]

        for i in xrange(length):
          dp[i][i] = piles[i]

        for i in xrange(1, length):
          for j in xrange(length - i):
            dp[j][i + j] = max(piles[j] - dp[j + 1][i + j],
                               piles[i + j] - dp[j][i + j - 1])

        return dp[0][-1] > 0
