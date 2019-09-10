// https://leetcode.com/problems/excel-sheet-column-number/
//
// algorithms
// Easy (52.25%)
// Total Accepted:    237,025
// Total Submissions: 453,594
// beats 100.0% of java submissions


class Solution {
    public int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int length = chs.length;

        int base = 1, res = 0;
        for (int i = length - 1; i >= 0; i--) {
            int bit = (chs[i] - 'A') + 1;
            res += bit * base;
            base *= 26;
        }

        return res;
    }
}