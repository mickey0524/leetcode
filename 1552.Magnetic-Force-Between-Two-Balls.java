// https://leetcode.com/problems/minimum-operations-to-make-array-equal/
// algorithms
// Medium (45.46%)
// Total Accepted: 7,092
// Total Submissions: 15,602


class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        if (m == 2) {
            return position[len - 1] - position[0];
        }

        int sum = position[len - 1] - position[0];
        int avg = sum / (m - 1);
        int l = 1, r = avg, mid = -1;
        int res = 1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (check(position, m - 1, mid)) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }

    private boolean check(int[] position, int m, int dis) {
        int len = position.length;
        int beginIdx = 0;
        for (int i = 1; i < len; i++) {
            if (position[i] - position[beginIdx] >= dis) {
                m--;
                beginIdx = i;
            }

            if (m == 0) {
                return true;
            }
        }

        return false;
    }

}