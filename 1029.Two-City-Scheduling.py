# https://leetcode.com/problems/two-city-scheduling/
# Easy (51.19%)
# Total Accepted:    3,913
# Total Submissions: 7,644

import math

class Solution(object):
    def twoCitySchedCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        def comp(c1, c2):
            return int(math.fabs(c2[0] - c2[1]) - math.fabs(c1[0] - c1[1]))

        costs.sort(cmp=comp)

        length = len(costs)
        threshold = length / 2
        A, B, res = 0, 0, 0

        for i in xrange(length):
            if costs[i][0] <= costs[i][1]:
                if A < threshold:
                    res += costs[i][0]
                    A += 1
                else:
                    res += costs[i][1]
                    B += 1
            else:
                if B < threshold:
                    res += costs[i][1]
                    B += 1
                else:
                    res += costs[i][0]
                    A += 1

        return res
