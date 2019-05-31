// https://leetcode.com/problems/spiral-matrix-ii/
//
// algorithms
// Medium (46.6%)
// Total Accepted: 136,356
// Total Submissions: 292,606
// beats 100.0% of java submissions

class Solution {
    public int[][] generateMatrix(int n) {
        int res[][] = new int[n][n];

        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1;
        boolean isOdd = (n & 1) == 1;

        while (true) {
            for (int i = l; i <= r; i++) {
                res[t][i] = num;
                num++;
            }
            t++;
            if (isOdd && l > r) {
                break;
            }

            for (int i = t; i <= b; i++) {
                res[i][r] = num;
                num++;
            }
            r--;

            for (int i = r; i >= l; i--) {
                res[b][i] = num;
                num++;
            }
            b--;
            if (!isOdd && (t > b)) {
                break;
            }

            for (int i = b; i >= t; i--) {
                res[i][l] = num;
                num++;
            }
            l++;
        }

        return res;
    }
}