// https://leetcode.com/problems/reverse-string-ii/
//
// algorithms
// Easy (46.55%)
// Total Accepted: 70,897
// Total Submissions: 152,493
// beats 100.0% of java submissions


class Solution {
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int delta = 2 * k;
        int tmp;

        for (int i = 0; i < len; i += delta) {
            tmp = len - i;
            if (tmp < k) {
                reverse(chs, i, len - 1);
            } else {
                reverse(chs, i, i + k - 1);
            }
        }

        return new String(chs);
    }

    private void reverse(char[] chs, int start, int end) {
        while (start < end) {
            swap(chs, start, end);
            start++;
            end--;
        }
    }

    private void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

}