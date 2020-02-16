// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
// algorithms
// Easy (84.57%)
// Total Accepted: 5,601
// Total Submissions: 6,623
// beats 100.0% of java submissions


class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int right = n - 1;
        int res = 0;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] < 0) {
                res += (n * (m - i));

                break;
            }
            right = binary(grid[i], 0, right);
            res += (n - 1 - right);
        }

        return res;
    }

    private int binary(int[] arr, int l, int r) {
        int m = -1;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] >= 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return r;
    }
}