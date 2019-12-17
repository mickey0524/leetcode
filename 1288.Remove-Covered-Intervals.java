// https://leetcode.com/problems/remove-covered-intervals/
// algorithms
// Medium (57.64%)
// Total Accepted: 2,445
// Total Submissions: 4,242


class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            } else {
                return o1[1] - o2[1];
            }
        });

        int deleteNum = 0;
        int len = intervals.length;
        int left = intervals[0][0], right = intervals[0][1];

        for (int i = 1; i < len; i++) {
            if (intervals[i][0] == left) {
                right = intervals[i][1];
                deleteNum++;
            } else if (intervals[i][1] <= right) {
                deleteNum++;
            } else {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }

        return len - deleteNum;
    }
}