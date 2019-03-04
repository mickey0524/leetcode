# https://leetcode.com/problems/product-of-array-except-self/
#
# algorithms
# Medium (53.88%)
# Total Accepted:    226,840
# Total Submissions: 421,016
# beats 100.0% of python submissions


class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        mul_res = 1
        length = len(nums)
        zero_idx = -1

        for idx, n in enumerate(nums):
            if n == 0:
                if zero_idx == -1:
                    zero_idx = idx
                else:
                    return [0] * length
            else:
                mul_res *= n

        if zero_idx != -1:
            res = [0] * length
            res[zero_idx] = mul_res
            return res

        for idx, n in enumerate(nums):
            nums[idx] = mul_res / n

        return nums
