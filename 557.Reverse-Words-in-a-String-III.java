// https://leetcode.com/problems/reverse-words-in-a-string-iii/
//
// algorithms
// Easy (64.06%)
// Total Accepted:    125,237
// Total Submissions: 195,508
// beats 100.0% of java submissions


class Solution {
    public String reverseWords(String s) {
        char[] chs = s.toCharArray();
        int pre = 0, i = 0, len = chs.length;

        for (; i < chs.length; i++) {
            if (chs[i] == ' ') {
                reverseCharArray(chs, pre, i - 1);
                pre = i + 1;
            }
        }

        reverseCharArray(chs, pre, len - 1);

        return new String(chs);
    }

    public void reverseCharArray(char[] chs, int i, int j) {
        while (i < j) {
            swap(chs, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}