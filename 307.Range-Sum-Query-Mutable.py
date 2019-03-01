# https://leetcode.com/problems/range-sum-query-mutable/
#
# algorithms
# Medium (27.45%)
# Total Accepted:    65,574
# Total Submissions: 238,851
# beats 100.0% of python submissions


class NumArray(object):

    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        length = len(nums)

        tree_arr = [0] * (length + 1)
        for i in xrange(1, length + 1):
            tree_arr[i] = nums[i - 1]

        for i in xrange(1, length + 1):
            j = i + (i & -i)
            if j <= length:
                tree_arr[j] += tree_arr[i]

        self.tree_arr = tree_arr
        self.nums = nums

    def update(self, i, val):
        """
        :type i: int
        :type val: int
        :rtype: void
        """
        delta = val - self.nums[i]
        self.nums[i] = val
        length = len(self.tree_arr)
        i += 1

        while i < length:
            self.tree_arr[i] += delta
            i = i + (i & -i)

    def prefixSum(self, i):
        i += 1
        res = 0

        while i > 0:
            res += self.tree_arr[i]
            i = i - (i & -i)

        return res

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        return self.prefixSum(j) - self.prefixSum(i - 1)


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(i,val)
# param_2 = obj.sumRange(i,j)
