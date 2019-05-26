// https://leetcode.com/problems/previous-permutation-with-one-swap/
//
// algorithms
// Medium (39.45%)
// Total Accepted: 1,588
// Total Submissions: 4,025
// beats 100.0% of java submissions


class Solution {
    public int[] prevPermOpt1(int[] A) {
        int len = A.length;
        if (len < 2) {
            return A;
        }

        int i = len - 2;
        for (; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                break;
            }
        }

        if (i == -1) {
            return A;
        }

        swap(A, i, searchIdx(A, i + 1, len - 1, A[i]));

        return A;
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public int searchIdx(int[] A, int i, int j, int target) {
        int idx = j;
        for (; idx >= i; idx--) {
            if (A[idx] < target) {
                break;
            }
        }

        while (idx > i && A[idx - 1] == A[idx]) {
            idx--;
        }

        return idx;
    }
}