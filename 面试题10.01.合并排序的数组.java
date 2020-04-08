// https://leetcode-cn.com/problems/sorted-merge-lcci/
// algorithms
// Easy (54.96%)
// Total Accepted: 19,597
// Total Submissions: 35,658


class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int insertIdx = A.length - 1;
        int aIdx = m - 1, bIdx = n - 1;

        while (aIdx >= 0 && bIdx >= 0) {
            if (A[aIdx] > B[bIdx]) {
                A[insertIdx--] = A[aIdx--];
            } else {
                A[insertIdx--] = B[bIdx--];
            }
        }

        if (aIdx > 0) {
            while (aIdx >= 0) {
                A[insertIdx--] = A[aIdx--];
            }
        } else {
            while (bIdx >= 0) {
                A[insertIdx--] = B[bIdx--];
            }
        }

        return;
    }
}