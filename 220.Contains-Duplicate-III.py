# https://leetcode.com/problems/permutation-in-string/description/
#
# algorithms
# Medium (18.93%)
# Total Accepted:    76.1k
# Total Submissions: 402k
# 参考http://bookshadow.com/weblog/2015/06/03/leetcode-contains-duplicate-iii/


from collections import OrderedDict


class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        if k < 1 or t < 0:
            return False

        od = OrderedDict()

        for idx, num in enumerate(nums):
            key = num / max(t, 1)
            for m in (key, key - 1, key + 1):
                if m in od and abs(num - od[m]) <= t:
                    return True
            od[key] = num
            if idx >= k:
                od.popitem(last=False)

        return False

