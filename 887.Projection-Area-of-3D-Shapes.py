# https://leetcode.com/problems/projection-area-of-3d-shapes/description/
#
# algorithms
# Easy (72.6%)
# Total Accepted:    2.3k
# Total Submissions: 3.1k


class Solution(object):
    def projectionArea(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        length = len(grid)
        xy, xz, yz = 0, 0, 0
        max_yz = [float('-inf')] * length

        for i in grid:
            max_xz = float('-inf')
            for idx, j in enumerate(i):
                if j != 0:
                    xy += 1
                if j > max_xz:
                    max_xz = j
                if j > max_yz[idx]:
                    max_yz[idx] = j
            xz += max_xz
        yz = sum(max_yz)

        return xy + yz + xz
