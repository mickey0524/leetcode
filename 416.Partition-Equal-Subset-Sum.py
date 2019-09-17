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


class Solution1(object):
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        nums_sum, nums_max, length = 0, float('-inf'), len(nums)
        for n in nums:
            nums_sum += n
            nums_max = max(nums_max, n)

        if nums_sum & 1 == 1:
            return False

        target = nums_sum >> 1
        if nums_max > target:
            return False

        nums.sort(reverse=True)
        res = [False]

        def recursive(idx, s):
            if res[0]:
                return

            if s == target:
                res[0] = True
                return

            if idx == length:
                return

            for i in xrange(idx, length):
                if s + nums[i] > target:
                    break

                recursive(i + 1, s + nums[i])

        recursive(0, 0)

        return res[0]
