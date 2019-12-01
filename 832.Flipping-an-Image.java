// https://leetcode.com/problems/flipping-an-image/
//
// algorithms
// Easy (74.03%)
// Total Accepted: 136,212
// Total Submissions: 183,986
// beats 100.0% of java submissions


class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length, col = A[0].length;

        for (int i = 0; i < row; i++) {
            reverse(A[i]);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                A[i][j] = 1 - A[i][j];
            }
        }

        return A;
    }

    private void reverse(int[] arr) {
        int len = arr.length;
        int i = 0, j = len - 1;
        int tmp = -1;

        while (i < j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}