# https://leetcode.com/problems/largest-triangle-area/
#
# algorithms
# Easy (54.56%)
# Total Accepted:    11,683
# Total Submissions: 21,415
# beats 94.00% of python submissions


from itertools import combinations

class Solution(object):
    def largestTriangleArea(self, points):
        """
        :type points: List[List[int]]
        :rtype: float
        """
        return max(0.5 * abs(i[0] * j[1] + j[0] * k[1] + k[0] * i[1] - i[0] * k[1] - k[0] * j[1] - j[0] * i[1])
                   for i, j, k in combinations(points, 3))