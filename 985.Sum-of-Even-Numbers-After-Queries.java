// https://leetcode.com/problems/sum-of-even-numbers-after-queries/
//
// algorithms
// Medium (62.4%)
// Total Accepted: 31,934
// Total Submissions: 51,174
// beats 100.0% of java submissions


class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int length = A.length;
        int[] res = new int[length];
        int evenSum = 0;
        for (int n : A) {
            if ((n & 1) == 0) {
                evenSum += n;
            }
        }

        for (int i = 0; i < length; i++) {
            int delta = queries[i][0], idx = queries[i][1];
            int tmp = delta + A[idx];

            if ((A[idx] & 1) == 0) {
                if ((tmp & 1) == 1) {
                    evenSum -= A[idx];
                } else {
                    evenSum += delta;
                }
            } else {
                if ((tmp & 1) == 0) {
                    evenSum += tmp;
                }
            }

            A[idx] += delta;
            res[i] = evenSum;
        }

        return res;
    }
}