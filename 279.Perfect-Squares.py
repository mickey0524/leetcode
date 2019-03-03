# https://leetcode.com/problems/perfect-squares/
#
# algorithms
# Medium (40.82%)
# Total Accepted:    162,998
# Total Submissions: 399,357


class Solution(object):

    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        if self.is_perfect_num(n):
            return 1

        perfect_num_arr = []

        i = 1
        while i * i < n:
            perfect_num_arr += (i ** 2),
            i += 1

        dp = [float('inf')] * (n + 1)
        for p_n in perfect_num_arr:
            dp[p_n] = 1

        for i in xrange(2, n + 1):
            cur_min = float('inf')
            for p_n in perfect_num_arr:
                if i - p_n <= 0:
                    break
                cur_min = min(cur_min, dp[i - p_n])

            dp[i] = min(dp[i], cur_min + 1)

        return dp[-1]

    def is_perfect_num(self, n):
        return int(math.sqrt(n)) ** 2 == n
