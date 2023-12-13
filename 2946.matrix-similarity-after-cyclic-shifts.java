// https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts/description/
// algorithms
// Easy (56.67%)
// Total Accepted: 17K
// Total Submissions: 30K


class Solution {

    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;

        if (m == 0) {
            return false;
        }

        int n = mat[0].length;
        k %= n;

        for (int i = 0; i < m; i++) {
            // 偶数往左，奇数往右
            int direction = i & 1;
            for (int j = 0; j < n; j++) {
                int targetIdx;
                if (direction == 0) {
                    targetIdx = j - k;
                    if (targetIdx < 0) {
                        targetIdx += n;
                    }
                } else {
                    targetIdx = (j + k) % n;
                }
                if (mat[i][j] != mat[i][targetIdx]) {
                    return false;
                }
            }
        }

        return true;
    }

}