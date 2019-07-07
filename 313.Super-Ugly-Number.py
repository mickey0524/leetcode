# https://leetcode.com/problems/super-ugly-number/
#
# algorithms
# Medium (41.77%)
# Total Accepted:    61,652
# Total Submissions: 147,607


class Solution(object):
    def nthSuperUglyNumber(self, n, primes):
        """
        :type n: int
        :type primes: List[int]
        :rtype: int
        """
        dp = [0] * n
        dp[0] = 1
        primes_len = len(primes)
        idxs = [0] * primes_len

        for i in xrange(1, n):
            cur_min = min([dp[idxs[j]] * p for j, p in enumerate(primes)])

            for j in xrange(primes_len):
                if primes[j] * dp[idxs[j]] == cur_min:
                    idxs[j] += 1

            dp[i] = cur_min

        return dp[-1]
