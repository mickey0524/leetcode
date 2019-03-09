# https://leetcode.com/problems/house-robber-ii/
#
# algorithms
# Medium (35.09%)
# Total Accepted:    107,028
# Total Submissions: 304,983
# beats 100.0% of python submissions


class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        
        if length == 0:
            return 0
        if length == 1:
            return nums[0]
        if length == 2:
            return max(nums)
        
        dp = [[0, 0] for _ in xrange(length + 1)]
        
        dp[1][0] = nums[0]
        
        for i in xrange(2, length):
            dp[i][0] = max(dp[i - 1][0], dp[i - 2][0] + nums[i - 1])
            dp[i][1] = max(dp[i - 1][1], dp[i - 2][1] + nums[i - 1])
        
        dp[length][1] = max(dp[length - 1][1], dp[length - 2][1] + nums[-1])

        return max(dp[-1][1], dp[-2][0])