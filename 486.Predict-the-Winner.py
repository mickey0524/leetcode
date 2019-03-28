# https://leetcode.com/problems/predict-the-winner/
#
# algorithms
# Medium (46.66%)
# Total Accepted:    47,121
# Total Submissions: 100,989
# beats 100.0% of python submissions


class Solution(object):
    def PredictTheWinner(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        length = len(nums)
        if length == 1:
            return True
        
        dp = [[0] * length for _ in xrange(length)]
        for i in xrange(length):
            dp[i][i] = nums[i]
        
        for i in xrange(1, length):
            for j in xrange(length - i):
                dp[j][i + j] = max(nums[j] - dp[j + 1][i + j], nums[i + j] - dp[j][i + j - 1])
        
        return dp[0][-1] >= 0
        