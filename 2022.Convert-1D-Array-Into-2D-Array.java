// https://leetcode.com/problems/convert-1d-array-into-2d-array/
// algorithms
// Easy (61.19%)
// Total Accepted: 8.2K
// Total Submissions: 13.4K


class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (m * n != len) {
            return new int[][]{};
        }
        
        int idx = 0;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[idx++];
            }
        }
        
        return res;
    }
}