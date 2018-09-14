# https://leetcode.com/problems/3sum/description/
#
# algorithms
# Medium (22.1%)
# Total Accepted:    379.1K
# Total Submissions: 1.7M
# beats 28.09% of python submissions


class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        length = len(nums)
        if length < 3:
            return []
        nums.sort()
        res, i = [], 0

        while i < length:
            while i > 0 and i < length and nums[i] == nums[i - 1]:
                i += 1
            head, tail = i + 1, length - 1
            while head < tail:
                cnt_sum = nums[i] + nums[head] + nums[tail]
                if cnt_sum > 0:
                    tail -= 1
                elif cnt_sum < 0:
                    head += 1
                else:
                    res.append([nums[i], nums[head], nums[tail]])
                    head, tail = head + 1, tail - 1
                    while head < tail and nums[head] == nums[head - 1]:
                        head += 1
                    while tail > head and nums[tail] == nums[tail + 1]:
                        tail -= 1
            i += 1

        return res
