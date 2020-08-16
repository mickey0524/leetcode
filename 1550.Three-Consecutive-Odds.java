// https://leetcode.com/problems/three-consecutive-odds/
// algorithms
// Easy (68.62%)
// Total Accepted: 7,734
// Total Submissions: 11,271
// beats 100.0% of java submissions


class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int len = arr.length;
        if (len < 3) {
            return false;
        }

        int i = 0;
        while (i < len - 2) {
            if ((arr[i] & 1) == 0) {
                i++;
                continue;
            } else {
                if ((arr[i + 1] & 1) == 0) {
                    i = i + 2;
                    continue;
                }

                if ((arr[i + 2] & 1) == 0) {
                    i = i + 3;
                    continue;
                }

                return true;
            }
        }

        return false;
    }
}