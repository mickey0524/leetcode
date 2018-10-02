# https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
#
# algorithms
# Easy (36.3%)
# Total Accepted:    6.1k
# Total Submissions: 16.8k
# beats 42.03% of python submissions


from bisect import insort


class KthLargest(object):

    def __init__(self, k, nums):
        """
        :type k: int
        :type nums: List[int]
        """
        nums.sort()
        self.nums = nums
        self.k = k

    def add(self, val):
        """
        :type val: int
        :rtype: int
        """
        insort(self.nums, val)

        return self.nums[-self.k]


# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)
