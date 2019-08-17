# https://leetcode.com/problems/partition-equal-subset-sum/
#
# algorithms
# Medium (41.3%)
# Total Accepted:    100,478
# Total Submissions: 243,238


class Solution(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        length = len(nums)
        s = sum(nums)
        if s & 1 == 1:
            return False

        target = s >> 1
        is_visited = {}

        if min(nums) > target:
            return False

        def recursive(idx, cur_sum):
            if cur_sum == target:
                return True

            if cur_sum > target or idx == length:
                return False

            for i in xrange(idx, length):
                if (i, cur_sum) in is_visited:
                    continue

                if recursive(i + 1, cur_sum + nums[i]):
                    return True

                is_visited[(i, cur_sum)] = False

            return False

        return recursive(0, 0)
