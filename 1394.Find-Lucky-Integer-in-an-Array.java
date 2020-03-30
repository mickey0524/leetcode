// https://leetcode.com/problems/find-lucky-integer-in-an-array/
// algorithms
// Easy (73.26%)
// Total Accepted: 8,860
// Total Submissions: 12,094
// beats 100.0% of java submissions


class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];

        for (int n : arr) {
            freq[n]++;
        }

        int res = -1;
        for (int i = 1; i <= 500; i++) {
            if (i == freq[i]) {
                res = i;
            }
        }

        return res;
    }
}