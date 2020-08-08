// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
// algorithms
// Easy (76.87%)
// Total Accepted: 13,907
// Total Submissions: 18,092
// beats 100.0% of java submissions


class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int diff = arr[1] - arr[0];

        for (int i = 2; i < len; i++) {
            int tmp = arr[i] - arr[i - 1];
            if (tmp != diff) {
                return false;
            }
        }

        return true;
    }
}