# https://leetcode.com/problems/burst-balloons/
#
# algorithms
# Hard (46.16%)
# Total Accepted:    56,690
# Total Submissions: 122,812

# 这道题是一道 dp 的题目，dp[i][j] 代表下标位 i，j 之间范围内 sum 最大的值
class Solution(object):
    def maxCoins(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = [1] + nums + [1]
        length = len(nums)

        dp = [[0] * length for _ in xrange(length)]

        for j in xrange(2, length):
            for i in xrange(j - 2, -1, -1):
                for k in xrange(i + 1, j):
                    dp[i][j] = max(dp[i][j], dp[i][k] + dp[k]
                                   [j] + nums[i] * nums[k] * nums[j])

        return dp[0][-1]
