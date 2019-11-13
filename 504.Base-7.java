// https://leetcode.com/problems/base-7/
//
// algorithms
// Easy (45.38%)
// Total Accepted: 47,025
// Total Submissions: 103,620


class Solution {
    public String convertToBase7(int num) {
        int flag = 1;
        if (num < 0) {
            flag = -1;
            num = -num;
        }

        int base = 1;
        while (base * 7 <= num) {
            base *= 7;
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0 || base > 0) {
            sb.append(num / base);
            num %= base;
            base /= 7;
        }

        if (flag == -1) {
            sb.insert(0, '-');
        }

        return sb.toString();
    }
}