// https://leetcode.com/problems/find-the-width-of-columns-of-a-grid/
// algorithms
// Easy (65.27%)
// Total Accepted: 17.1K
// Total Submissions: 26.2K


class Solution {

    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int maxColLen = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                String tmp = String.valueOf(grid[j][i]);
                int tmpLen = tmp.length();
                maxColLen = Math.max(maxColLen, tmpLen);
            }
            res[i] = maxColLen;
        }

        return res;
    }

}