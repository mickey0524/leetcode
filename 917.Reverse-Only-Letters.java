// https://leetcode.com/problems/reverse-only-letters/
//
// algorithms
// Easy (56.7%)
// Total Accepted: 40,649
// Total Submissions: 71,689


class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chs = S.toCharArray();
        int len = chs.length;
        int i = 0, j = len - 1;

        while (i < j) {
            while (i < j && !isLetter(chs[i])) {
                i++;
            }
            while (i < j && !isLetter(chs[j])) {
                j--;
            }

            swap(chs, i, j);
            i++;
            j--;
        }

        return new String(chs);
    }

    private void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    private boolean isLetter(char ch) {
        int tmp = ch - 'a';
        if (tmp >= 0 && tmp <= 25) {
            return true;
        }

        tmp = ch - 'A';
        if (tmp >= 0 && tmp <= 25) {
            return true;
        }

        return false;
    }

}