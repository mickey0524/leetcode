# https://leetcode.com/problems/reshape-the-matrix/
#
# algorithms
# Easy (58.16%)
# Total Accepted:    67,646
# Total Submissions: 116,319

class Solution(object):
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        row, col = len(nums), len(nums[0])
        
        if r * c != row * col:
            return nums
        
        res = [[0] * c for _ in xrange(r)]
        old_i, old_j = 0, 0
        
        for i in xrange(r):
            for j in xrange(c):
                if old_j == col:
                    old_i += 1
                    old_j = 0
                res[i][j] = nums[old_i][old_j]
                old_j += 1
                
        return res
    