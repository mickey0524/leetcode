// https://leetcode.com/problems/sort-the-matrix-diagonally/
// algorithms
// Medium (77.16%)
// Total Accepted: 2,571
// Total Submissions: 3,332
// beats 100.0% of java submissions


class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        ArrayList<int[]> indexList = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();

        int row = m - 1, col = 0;
        for (int i = 0; i < m + n - 1; i++) {
            indexList.clear();
            numList.clear();

            int j = row, k = col;
            while (j < m && k < n) {
                numList.add(mat[j][k]);
                indexList.add(new int[] { j, k });
                j++;
                k++;
            }

            Collections.sort(numList);
            for (j = 0; j < numList.size(); j++) {
                int[] p = indexList.get(j);
                mat[p[0]][p[1]] = numList.get(j);
            }

            if (row != 0) {
                row--;
            } else if (row == 0 && col == 0) {
                col = 1;
            } else {
                col++;
            }
        }

        return mat;
    }
}