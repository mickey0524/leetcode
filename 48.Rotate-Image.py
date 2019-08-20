# https://leetcode.com/problems/rotate-image/
#
# algorithms
# Medium (50.0%)
# Total Accepted:    277,919
# Total Submissions: 555,398


class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        
        for i in xrange((n + 1) / 2):
            l, r = i, n - 1 - i
            t, b = l, r
            if l == r:
                break
            
            tmp = matrix[t][r]
            matrix[t][r] = matrix[t][l]
            tmp1 = matrix[b][r]
            matrix[b][r] = tmp
            matrix[t][l] = matrix[b][l]
            matrix[b][l] = tmp1
            
            tmp = []
            for i in xrange(t + 1, b):
                tmp.append(matrix[i][r])
                matrix[i][r] = matrix[t][i]
            
            tmp1 = []
            for i in xrange(r - 1, l, -1):
                tmp1.append(matrix[b][i])
                matrix[b][i] = tmp[r - 1 - i]
            
            for i in xrange(l + 1, r):
                matrix[t][i] = matrix[b - (i - l)][l]
            
            for i in xrange(b - 1, t, -1):
                matrix[i][l] = tmp1[b - 1 - i]
        
        return
            