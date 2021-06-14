// https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/
// algorithms
// Easy (48.88%)
// Total Accepted: 8.7K
// Total Submissions: 17.8K


class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];

        for (int[] r : ranges) {
            for (int i = r[0]; i <= r[1]; i++) {
                flag[i] = true;
            }
        }

        for (int i = left; i <= right; i++) {
            if (!flag[i]) {
                return false;
            }
        }

        return true;
    }
}