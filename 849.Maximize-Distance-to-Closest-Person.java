// https://leetcode.com/problems/maximize-distance-to-closest-person/
//
// algorithms
// Easy (41.74%)
// Total Accepted: 43,367
// Total Submissions: 103,900


class Solution {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;

        int firstIdx = -1;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 1) {
                firstIdx = i;
                break;
            }
        }

        int lastIdx = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                lastIdx = i;
                break;
            }
        }

        if (firstIdx == lastIdx) {
            return Math.max(firstIdx, len - 1 - firstIdx);
        }

        int res = Math.max(firstIdx, len - 1 - lastIdx);
        int preIdx = firstIdx;
        for (int i = firstIdx + 1; i <= lastIdx; i++) {
            if (seats[i] == 1) {
                res = Math.max(res, (i - preIdx) / 2);
                preIdx = i;
            }
        }

        return res;
    }
}