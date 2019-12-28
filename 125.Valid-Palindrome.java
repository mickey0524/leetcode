// https://leetcode.com/problems/valid-palindrome/
//
// algorithms
// Easy (33.42%)
// Total Accepted: 457,696
// Total Submissions: 1,369,350


class Solution {

    public boolean isPalindrome(String s) {
        int len = s.length();
        char[] chs = s.toLowerCase().toCharArray();

        int i = 0, j = len - 1;
        while (i < j) {
            while (i < j && !isLetterOrNum(chs[i])) {
                i++;
            }

            while (i < j && !isLetterOrNum(chs[j])) {
                j--;
            }

            if (i < j && chs[i] != chs[j]) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public boolean isLetterOrNum(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }

        if (ch >= '0' && ch <= '9') {
            return true;
        }

        return false;
    }

}