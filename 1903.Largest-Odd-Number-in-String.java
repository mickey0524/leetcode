// https://leetcode.com/problems/largest-odd-number-in-string/
// algorithms
// Easy (56.76%)
// Total Accepted: 8.4K
// Total Submissions: 14.8K


class Solution {
    public String largestOddNumber(String num) {
        int len = num.length();

        for (int i = len - 1; i >= 0; i--) {
            if (isOdd(num.charAt(i))) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }

    private boolean isOdd(char ch) {
        int num = (int) (ch - '0');

        return (num & 1) == 1;
    }
}