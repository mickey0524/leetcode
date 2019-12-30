// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
// algorithms
// Easy (78.51%)
// Total Accepted: 5,278
// Total Submissions: 6,723
// beats 100.0% of java submissions


class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];

        if ((n & 1) == 1) {
            for (int i = 1; i < n; i += 2) {
                res[i] = i;
                res[i + 1] = -i;
            }
        } else {
            for (int i = 0; i < n; i += 2) {
                res[i] = i + 1;
                res[i + 1] = -(i + 1);
            }
        }

        return res;
    }
}