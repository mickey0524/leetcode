# https://leetcode.com/problems/target-sum/
#
# algorithms
# Medium (46.66%)
# Total Accepted:    106,399
# Total Submissions: 233,213


class Solution(object):
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        length = len(nums)
        is_visited = {}

        def recursive(idx, cur_s):
            if (idx, cur_s) in is_visited:
                return is_visited[(idx, cur_s)]

            if idx == length:
                is_visited[(idx, cur_s)] = 0
                if cur_s == 0:
                    is_visited[(idx, cur_s)] = 1

                return is_visited[(idx, cur_s)]

            n = recursive(idx + 1, cur_s -
                          nums[idx]) + recursive(idx + 1, cur_s + nums[idx])
            is_visited[(idx, cur_s)] = n

            return n

        recursive(0, S)

        return is_visited[(0, S)]


class Solution1(object):
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        length = len(nums)
        if length == 0:
            return 0

        dp = [{} for _ in xrange(length)]
        if nums[0] == 0:
            dp[0][0] = 2
        else:
            dp[0][nums[0]] = 1
            dp[0][-nums[0]] = 1

        for i in xrange(1, length):
            for k, v in dp[i - 1].iteritems():
                dp[i][k + nums[i]] = dp[i].get(k + nums[i], 0) + v
                dp[i][k - nums[i]] = dp[i].get(k - nums[i], 0) + v

        return dp[length - 1].get(S, 0)
