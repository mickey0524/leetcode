// https://leetcode.com/problems/consecutive-characters/
// algorithms
// Easy (82.12%)
// Total Accepted: 13,370
// Total Submissions: 16,281
// beats 100.0% of java submissions


class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length;
        int res = 0;

        for (int i = 0; i < len; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                res++;
            }
        }

        return res;
    }
}