# https://leetcode.com/problems/maximum-of-absolute-value-expression/
# Medium (48.42%)
# Total Accepted:    1,884
# Total Submissions: 3,891


class Solution(object):
    def maxAbsValExpr(self, arr1, arr2):
        """
        :type arr1: List[int]
        :type arr2: List[int]
        :rtype: int
        """
        length = len(arr1)
        cur_max = length - 1 + \
            abs(arr1[-1] - arr1[0]) + abs(arr2[-1] - arr2[0])

        for x_d, y_d in [(1, 1), (1, -1), (-1, 1), (-1, -1)]:
            max_v, min_v = float('-inf'), float('inf')

            for i in xrange(length):
                max_v = max(max_v, arr1[i] * x_d + arr2[i] * y_d + i)
                min_v = min(min_v, arr1[i] * x_d + arr2[i] * y_d + i)

            cur_max = max(cur_max, max_v - min_v)

        return cur_max
