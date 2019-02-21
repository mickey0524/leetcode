# https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
#
# algorithms
# Medium (40.95%)
# Total Accepted:    34,470
# Total Submissions: 84,179
# beats 100.0% of python submissions


class Solution(object):
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        length = len(nums)
        nums_sum = sum(nums)
        if nums_sum % k != 0:
            return False
        target = nums_sum / k
        nums.sort(reverse=True)
        nums_flag = [-1] * length

        def recursive(idx, cnt_s, cnt_k, subset_len):
            if cnt_s > target or subset_len > length - k + 1:
                return False

            if cnt_k == k:
                return True

            if cnt_s == target:
                return recursive(0, 0, cnt_k + 1, 0)

            for i in xrange(idx, length):
                if nums_flag[i] == -1:
                    nums_flag[i] = cnt_k
                    if recursive(i + 1, cnt_s + nums[i], cnt_k, subset_len + 1):
                        return True
                    nums_flag[i] = -1

            return False

        return recursive(0, 0, 0, 0)
