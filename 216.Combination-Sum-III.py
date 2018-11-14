# https://leetcode.com/problems/combination-sum-iii/description/
#
# algorithms
# Medium (49.24%)
# Total Accepted:    104.2K
# Total Submissions: 211.6K
# beats 100.0% of python submissions


class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        if n < 6:
            return []

        res = [[]]

        def resursive(idx, cnt_n, path, num):
            if num == n and cnt_n == k:
                res[0] += path,
                return

            if num > n or cnt_n > k:
                return

            for i in xrange(idx, 10):
                resursive(i + 1, cnt_n + 1, path + [i], num + i)

        resursive(1, 0, [], 0)

        return res[0]
