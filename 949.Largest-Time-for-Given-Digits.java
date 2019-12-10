// https://leetcode.com/problems/largest-time-for-given-digits/
//
// algorithms
// Easy (34.8%)
// Total Accepted: 11.8K
// Total Submissions: 33.9K


class Solution {

    private static String res;
    private static final int[] UPPER = new int[] { 2, 3, 5, 9 };

    public String largestTimeFromDigits(int[] A) {
        res = null;

        Arrays.sort(A);
        int[] path = new int[4];
        boolean[] isVisited = new boolean[4];

        recursive(A, path, isVisited, 0);

        return res == null ? "" : res;
    }

    private void recursive(int[] A, int[] path, boolean[] isVisited, int timeIdx) {
        if (res != null) {
            return;
        }

        if (timeIdx == 4) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 2; i++) {
                sb.append(path[i]);
            }
            sb.append(':');
            for (int i = 2; i < 4; i++) {
                sb.append(path[i]);
            }
            res = sb.toString();
            return;
        }

        for (int i = 3; i >= 0; i--) {
            if (!isVisited[i]) {
                if (timeIdx == 1) {
                    if (path[0] == 2 && A[i] > UPPER[timeIdx]) {
                        continue;
                    }
                } else if (A[i] > UPPER[timeIdx]) {
                    continue;
                }
                isVisited[i] = true;
                path[timeIdx] = A[i];
                recursive(A, path, isVisited, timeIdx + 1);
                isVisited[i] = false;
            }
        }
    }

}