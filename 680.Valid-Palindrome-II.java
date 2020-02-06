// https://leetcode.com/problems/valid-palindrome-ii/
//
// algorithms
// Easy (35.73%)
// Total Accepted: 120,370
// Total Submissions: 336,906


class Solution {

    private static final int UNUSED = -1;
    private static final int USED = -2;
    private static final int USING = -3;

    public boolean validPalindrome(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int i = 0, j = len - 1;
        int tmp = UNUSED;
        int iTmp = -1, jTmp = -1;

        while (i < j) {
            if (chs[i] == chs[j]) {
                i++;
                j--;
            } else if (tmp == UNUSED) {
                tmp = USING;
                iTmp = i + 1;
                jTmp = j--;
            } else if (tmp == USED) {
                return false;
            } else {
                tmp = USED;
                i = iTmp;
                j = jTmp;
            }
        }

        return true;
    }

}