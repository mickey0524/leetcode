// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
//
// algorithms
// Medium (49.13%)
// Total Accepted:    105,212
// Total Submissions: 214,139

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int l = matrix[0][0], r = matrix[row - 1][col - 1], m = -1;
        
        while (l < r) {
            m = l + (r - l) / 2;
            if (helper(matrix, m) >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    public int helper(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = col - 1;
        int res = 0;
        
        while (i < row && j >= 0) {
            if (matrix[i][j] <= target) {
                res += (j + 1);
                i++;
            } else {
                j--;
            }
        }
        
        return res;
    }
}