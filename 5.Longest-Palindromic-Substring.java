// https://leetcode.com/problems/zigzag-conversion/
//
// algorithms
// Medium (28.53%)
// Total Accepted: 758,699
// Total Submissions: 2,659,095


class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        char[] chArr = s.toCharArray();
        int palindromeLen = 1;
        String res = s.substring(0, 1);

        for (int i = 1; i < len; i++) {
            if (chArr[i] == chArr[i - 1]) {
                int l = i - 2, r = i + 1;
                while (l >= 0 && r < len) {
                    if (chArr[l] == chArr[r]) {
                        l--;
                        r++;
                    } else {
                        break;
                    }
                }
                int tmp = r - l - 1;
                if (tmp > palindromeLen) {
                    palindromeLen = tmp;
                    res = s.substring(l + 1, r);
                }
            }
            if (i < len - 1 && chArr[i - 1] == chArr[i + 1]) {
                int l = i - 2, r = i + 2;
                while (l >= 0 && r < len) {
                    if (chArr[l] == chArr[r]) {
                        l--;
                        r++;
                    } else {
                        break;
                    }
                }
                int tmp = r - l - 1;
                if (tmp > palindromeLen) {
                    palindromeLen = tmp;
                    res = s.substring(l + 1, r);
                }
            }
        }

        return res;
    }
}