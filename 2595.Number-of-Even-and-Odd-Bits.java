// https://leetcode.com/problems/number-of-even-and-odd-bits/
// algorithms
// Easy (68.4%)
// Total Accepted: 17.6K
// Total Submissions: 25.7K


class Solution {

    public int[] evenOddBit(int n) {
        String binaryStr = Integer.toBinaryString(int i);
        int even = 0;
        int odd = 0;

        int len = binaryStr.length();
        for (int i = len - 1; i >= 0; i--) {
            if (binaryStr.charAt(i) == '1') {
                int idx = len - 1 - i;
                if ((idx & 1) == 0) {
                    even += 1;
                } else {
                    odd += 1;
                }
            }
        }

        return new int[]{even, odd};
    }

}