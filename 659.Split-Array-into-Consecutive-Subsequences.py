# https://leetcode.com/problems/split-array-into-consecutive-subsequences/description/
#
# algorithms
# Medium (37.34%)
# Total Accepted:    11.8k
# Total Submissions: 31.6k
# beats 24.02% of python submissions


from collections import Counter


class Solution(object):
    def isPossible(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        freq_counter = Counter(nums)
        need_counter = Counter()

        for num in nums:
            if freq_counter[num] == 0:
                continue
            elif need_counter[num] > 0:
                need_counter[num] -= 1
                need_counter[num + 1] += 1
            elif freq_counter[num + 1] > 0 and freq_counter[num + 2] > 0:
                freq_counter[num + 1] -= 1
                freq_counter[num + 2] -= 1
                need_counter[num + 3] += 1
            else:
                return False
            freq_counter[num] -= 1

        return True
