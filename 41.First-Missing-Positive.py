# https://leetcode.com/problems/count-and-say/description/
#
# algorithms
# Hard (27.1%)
# Total Accepted:    165.2k
# Total Submissions: 609.6k
# beats 100.0% of python submissions
# 我的方法是采用位运算来做，用bit串的每一位来指代一个positive num

class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        bit = 0

        for n in nums:
            if n > 0:
                bit |= 1 << (n - 1)

        flag = 0

        while bit != 0:
            if (bit & 1 == 0):
                break
            flag += 1
            bit >>= 1

        return flag + 1

# 查看Discuss，发现还有一种巧妙的解法，交换数组中的元素使得nums[i]存放i + 1
# 最后遍历即可得到缺失的正整数 

class Solution:
    def firstMissingPositive(self, nums):
        for i in range(len(nums)):
            while nums[i] > 0 and nums[i] <= len(nums) and nums[nums[i]-1] != nums[i]:
                target_idx = nums[i]-1
                nums[i], nums[target_idx] = nums[target_idx], nums[i]
        for i in range(len(nums)):
            if nums[i] != i+1:
                return i+1
        return len(nums)+1

class Solution1(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length = len(nums)
        if length == 0:
            return 1
        if length == 1:
            return 1 if nums[0] != 1 else 2

        for i in xrange(length):

            while nums[i] >= 0 and nums[i] < length and nums[i] != i:
                if nums[nums[i]] == nums[i]:
                    break

                tmp = nums[nums[i]]
                nums[nums[i]] = nums[i]
                nums[i] = tmp

        for i in xrange(1, length):
            if nums[i] != i:
                return i

        return length if nums[0] != length else length + 1
