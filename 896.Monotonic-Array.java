// https://leetcode.com/problems/monotonic-array/
//
// algorithms
// Easy (56.09%)
// Total Accepted:    61,928
// Total Submissions: 110,418


class Solution {
    public boolean isMonotonic(int[] A) {
        int isInc = 0;
        int length = A.length;

        for (int i = 1; i < length; i++) {
            if (A[i] == A[i - 1]) {
                continue;
            } else if (isInc == 0) {
                isInc = A[i] > A[i - 1] ? 1 : -1;
            } else {
                if (isInc == 1 && A[i] < A[i - 1]) {
                    return false;
                }
                if (isInc == -1 && A[i] > A[i - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}