// https://leetcode.com/problems/sort-array-by-parity/
//
// algorithms
// Easy (73.23%)
// Total Accepted: 145,743
// Total Submissions: 199,020


class Solution {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        int preIdx = 0;

        for (int i = 0; i < len; i++) {
            if ((A[i] & 1) == 0) {
                swap(A, preIdx++, i);
            }
        }

        return A;
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}