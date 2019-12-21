// https://leetcode.com/problems/sort-array-by-parity-ii/
//
// algorithms
// Easy (67.58%)
// Total Accepted: 68,801
// Total Submissions: 101,803
// beats 100.0% of java submissions


class Solution {
    public int[] sortArrayByParityII(int[] A) {
        boolean isOdd = false;
        int pre = 0;
        int len = A.length;
        int idx = 0;

        while (idx < len) {
            if (isOdd) {
                if ((A[idx] & 1) == 1) {
                    swap(A, idx, pre);
                    pre++;
                    isOdd = !isOdd;
                } else {
                    idx++;
                }
            } else {
                if ((A[idx] & 1) == 0) {
                    swap(A, idx, pre);
                    pre++;
                    isOdd = !isOdd;
                } else {
                    idx++;
                }
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