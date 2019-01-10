# https://leetcode.com/problems/search-a-2d-matrix/
#
# algorithms
# Medium (34.56%)
# Total Accepted:    197,044
# Total Submissions: 570,085


class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        row = len(matrix)
        if row == 0:
            return False
        col = len(matrix[0])
        
        x, y = 0, col - 1
        while x < row and y >= 0:
            if matrix[x][y] == target:
                return True
            elif matrix[x][y] > target:
                y -= 1
            else:
                x += 1
        
        return False
    