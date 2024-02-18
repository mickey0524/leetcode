// https://leetcode.com/problems/modify-the-matrix/description/
// algorithms
// Easy (67.1%)
// Total Accepted: 28.3K
// Total Submissions: 42.2K


class Solution {

    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            List<Integer> idxList = new LinkedList<>();
            int maxValue = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                if (matrix[j][i] == -1) {
                    idxList.add(j);
                } else {
                    res[j][i] = matrix[j][i];
                    maxValue = Math.max(maxValue, matrix[j][i]);
                }
            }

            for (int idx : idxList) {
                res[idx][i] = maxValue;
            }
        }

        return res;
    }

}