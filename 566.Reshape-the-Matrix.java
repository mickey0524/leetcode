// https://leetcode.com/problems/reshape-the-matrix/
//
// algorithms
// Easy (47.30%)
// Total Accepted: 92,216
// Total Submissions: 153,991
// beats 100.0% of java submissions


class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;

        if (r * c != m * n) {
            return nums;
        }

        int[][] res = new int[r][c];
        int xIdx = 0, yIdx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = nums[xIdx][yIdx];

                yIdx++;
                if (yIdx == n) {
                    xIdx++;
                    yIdx = 0;
                }
            }
        }

        return res;
    }
}