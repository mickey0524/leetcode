# https://leetcode.com/problems/diet-plan-performance/
# Easy (42.92%)
# Total Accepted:    2,977
# Total Submissions: 6,936
# beats 100.0% of python submissions


class Solution(object):
    def dietPlanPerformance(self, calories, k, lower, upper):
        """
        :type calories: List[int]
        :type k: int
        :type lower: int
        :type upper: int
        :rtype: int
        """
        length = len(calories)
        c = 0
        res = 0

        for i in xrange(k):
            c += calories[i]

        for i in xrange(k, length + 1):
            if c < lower:
                res -= 1
            elif c > upper:
                res += 1

            if i == length:
                break

            c += calories[i]
            c -= calories[i - k]

        return res
