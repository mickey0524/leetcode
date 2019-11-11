// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
// algorithms
// Easy (80.38%)
// Total Accepted: 4,699
// Total Submissions: 5,846
// beats 100.0% of java submissions


class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];
        int res = 0;

        for (int[] pair : indices) {
            row[pair[0]]++;
            col[pair[1]]++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (((row[i] + col[j]) & 1) == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}