// https://leetcode.com/problems/find-the-sum-of-encrypted-integers/description/
// algorithms
// Easy (70.7%)
// Total Accepted: 27K
// Total Submissions: 38.2K


class Solution {

    public int sumOfEncryptedInt(int[] nums) {
        int res = 0;

        for (int n : nums) {
            int maxDigit = Integer.MIN_VALUE;
            int digitNum = 0;
            while (n > 0) {
                maxDigit = Math.max(maxDigit, n % 10);
                n /= 10;
                digitNum += 1;
            }

            int tmp = 0;
            for (int i = 0; i < digitNum; i++) {
                tmp = tmp * 10 + maxDigit;
            }
            
            res += tmp;
        }

        return res;
    }

}