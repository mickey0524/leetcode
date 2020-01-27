// https://leetcode.com/problems/remove-palindromic-subsequences/
// algorithms
// Easy (49.94%)
// Total Accepted: 3,566
// Total Submissions: 7,141
// beats 100.0% of java submissions


class Solution {
    public int removePalindromeSub(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        return isPalindrome(s) ? 1 : 2;
    }

    private boolean isPalindrome(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length - 1;

        while (i < j) {
            if (chs[i] != chs[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}