// https://leetcode.com/problems/spiral-matrix/
//
// algorithms
// Medium (30.45%)
// Total Accepted: 234,074
// Total Submissions: 768,688
// beats 100.0% of java submissions


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        if (matrix == null) {
            return res;
        }
        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;

        int l = 0, r = n - 1, t = 0, b = m - 1;
        while (t <= b && l <= r) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            t++;

            if (t > b) {
                break;
            }

            for (int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            r--;
            if (r < l) {
                break;
            }

            for (int i = r; i >= l; i--) {
                res.add(matrix[b][i]);
            }
            b--;

            for (int i = b; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }

        return res;
    }
}