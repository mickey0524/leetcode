// https://leetcode-cn.com/problems/exchange-lcci/
// algorithms
// Easy (68.13%)
// Total Accepted: 1,073
// Total Submissions: 1,575


class Solution {
    public int exchangeBits(int num) {
        String str = Integer.toBinaryString(num);
        char[] chArr = str.toCharArray();
        int len = chArr.length;
        int res = 0, base = 1;

        for (int i = len - 1; i >= 0; i -= 2) {
            if (i == 0) {
                base <<= 1;
                res += (chArr[i] - '0') * base;
            } else {
                res += (chArr[i - 1] - '0') * base;
                base <<= 1;
                res += (chArr[i] - '0') * base;
                base <<= 1;
            }
        }

        return res;
    }

}