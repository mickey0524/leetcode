# https://leetcode.com/problems/construct-quad-tree/
#
# algorithms
# Easy (53.44%)
# Total Accepted:    5,323
# Total Submissions: 9,960
# beats 97.50% of python submissions

"""
# Definition for a QuadTree node.
class Node(object):
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight
"""
class Solution(object):
    def construct(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: Node
        """
        return self.resursive(grid, 0, 0, len(grid))
    
    def resursive(self, grid, x, y, N):
        if N == 1:
            return Node(bool(grid[x][y]), True, None, None, None, None)
        
        value = grid[x][y]
        
        for i in xrange(x, x + N):
            for j in xrange(y, y + N):
                if grid[i][j] != value:
                    value = '*'
            if value == '*':
                break
                
        if value != '*':
            return Node(bool(grid[x][y]), True, None, None, None, None)
        
        return Node(True,
                    False,
                    self.resursive(grid, x, y, N / 2),
                    self.resursive(grid, x, y + N / 2, N / 2),
                    self.resursive(grid, x + N / 2, y, N / 2),
                    self.resursive(grid, x + N / 2, y + N / 2, N / 2))
        