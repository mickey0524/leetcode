# https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/
#
# algorithms
# Easy (29.26%)
# Total Accepted:    45k
# Total Submissions: 153.8k
# beats 15.59% of python submissions


class Solution(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        sorted_nums = map(lambda (idx, n): (n, idx), enumerate(nums))
        sorted_nums.sort()
        head, tail = 0, length - 1

        for i in xrange(length):
            head = i
            if sorted_nums[i][1] != i:
                break

        for i in xrange(length - 1, head + 1, -1):
            tail = i
            if sorted_nums[i][1] != i:
                break

        return tail - head + 1


class Solution1(object):
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length < 2:
            return 0

        cur_min, l = nums[-1], -1
        for i in xrange(length - 2, -1, -1):
            if nums[i] < cur_min:
                cur_min = nums[i]
            elif nums[i] > cur_min:
                l = i

        cur_max, r = nums[0], -1
        for i in xrange(length):
            if nums[i] > cur_max:
                cur_max = nums[i]
            elif nums[i] < cur_max:
                r = i

        return 0 if l == r else r - l + 1
