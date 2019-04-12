# https://leetcode.com/problems/subarray-product-less-than-k/
#
# algorithms
# Medium (36.42%)
# Total Accepted:    27,189
# Total Submissions: 74,658


class Solution(object):
    def numSubarrayProductLessThanK(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if k == 0:
            return 0

        length = len(nums)
        l, r, cur_sum = 0, 0, 1
        res = 0

        while r < length:
            # if cur_sum < k:
            cur_sum *= nums[r]

            while cur_sum >= k and l <= r:
                cur_sum /= nums[l]
                l += 1
            res += (r - l + 1)
            r += 1

        return res
