# https://leetcode.com/problems/non-decreasing-array/description/
#
# algorithms
# Easy (19.75%)
# Total Accepted:    33.8k
# Total Submissions: 171.1k
# beats 100.0% of python submissions


# 这道题主要cover几种符合情况的条件就行
# 当出现两次下降的时候，肯定是False，而没有出现下降，一定是True
# 当一次下降的时候，如果是在首尾出现的，直接修改两端即可 ex: [4, 1, 2] [1, 3, 2]
# 出现在中间的时候，可以修改下降点或者是下降点前面一个节点来使得序列符合要求 [1, 3, 4, 2, 4, 5] [1, 5, 2, 3, 4]

class Solution(object):
    def checkPossibility(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        length = len(nums)
        descend_point = None

        for i in xrange(1, length):
            if nums[i] < nums[i - 1]:
                if descend_point is not None:
                    return False
                descend_point = i

        if descend_point is None:
            return True

        if descend_point == 1 or descend_point == length - 1:
            return True

        if nums[descend_point - 2] <= nums[descend_point] or nums[descend_point + 1] >= nums[descend_point - 1]:
            return True

        return False
