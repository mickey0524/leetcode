# https://leetcode.com/problems/wiggle-subsequence/
#
# algorithms
# Medium (36.9%)
# Total Accepted:    43,722
# Total Submissions: 118,490
# beats 100.0% of python submissions


class Solution(object):
    def wiggleMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)

        if length < 2:
            return length

        dp = [[0] * 2 for _ in xrange(length)]
        dp[0] = [1, 1]

        for i in xrange(1, length):
            if nums[i] > nums[i - 1]:
                dp[i][0] += dp[i - 1][1] + 1
                dp[i][1] = dp[i - 1][1]
            elif nums[i] < nums[i - 1]:
                dp[i][1] += dp[i - 1][0] + 1
                dp[i][0] = dp[i - 1][0]
            else:
                dp[i] = dp[i - 1]

        return max(dp[-1])
