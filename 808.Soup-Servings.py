# https://leetcode.com/problems/soup-servings/
#
# algorithms
# Medium (38.04%)
# Total Accepted:    6,929
# Total Submissions: 18,216


class Solution(object):
    def soupServings(self, N):
        """
        :type N: int
        :rtype: float
        """
        # 这个 N > 4800 是真的蠢。。。不然这就是一道好题目
        if N > 4800:
            return 1

        hash_map = {}

        def recursive(m, n):
            if (m, n) in hash_map:
                return hash_map[(m, n)]

            if m <= 0 and n > 0:
                ans = 1

            elif m <= 0 and n <= 0:
                ans = 0.5

            elif m > 0 and n <= 0:
                ans = 0

            else:
                ans = 0.25 * (recursive(m - 100, n) + recursive(m - 75, n - 25) + recursive(m - 50, n - 50) + recursive(
                    m - 25, n - 75))

            hash_map[(m, n)] = ans

            return ans

        return recursive(N, N)
