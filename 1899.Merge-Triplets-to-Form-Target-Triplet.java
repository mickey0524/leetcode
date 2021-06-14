// https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
// algorithms
// Medium (56.76%)
// Total Accepted: 6.3K
// Total Submissions: 11.1K


class Solution {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] flag = new boolean[3];

        for (int[] t : triplets) {
            boolean[] tmp = new boolean[3];
            boolean isOk = true;

            for (int i = 0; i < 3; i++) {
                if (t[i] > target[i]) {
                    isOk = false;
                    break;
                } else if (t[i] == target[i]) {
                    tmp[i] = true;
                }
            }

            if (!isOk) {
                continue;
            }

            for (int i = 0; i < 3; i++) {
                if (tmp[i]) {
                    flag[i] = tmp[i];
                }
            }

            if (isOk && check(flag)) {
                return true;
            }
        }

        return false;
    }

    private boolean check(boolean[] flag) {
        for (boolean f : flag) {
            if (!f) {
                return false;
            }
        }

        return true;
    }

}