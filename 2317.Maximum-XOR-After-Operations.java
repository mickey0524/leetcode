// https://leetcode.com/problems/maximum-xor-after-operations/
// algorithms
// Medium (70.53%)
// Total Accepted: 6.7K
// Total Submissions: 9.5K


class Solution {

    public int maximumXOR(int[] nums) {
        boolean[] flag = new boolean[32];

        for (int i = 0; i < 32; i++) {
            if (flag[i]) {
                continue;
            }

            int tmp = 1 << i;
            for (int n : nums) {
                if ((tmp & n) == tmp) {
                    flag[i] = true;
                    break;
                }
            }
        }

        int res = 0;
        int tmp = 1;
        for (int i = 0; i < 32; i++) {
            if (flag[i]) {
                res += tmp;
            }

            tmp <<= 1;
        }

        return res;
    }

}