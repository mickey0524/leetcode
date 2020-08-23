// https://leetcode.com/problems/thousand-separator/
// algorithms
// Easy (62.05%)
// Total Accepted: 7,479
// Total Submissions: 12,054
// beats 100.0% of java submission


class Solution {

    private static final char POINT = '.';

    public String thousandSeparator(int n) {
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(n);
        int len = s.length();
        if (len <= 3) {
            return s;
        }

        for (int i = len - 3;; i -= 3) {
            sb.insert(0, s.substring(i, i + 3)).insert(0, POINT);

            if (i < 4) {
                sb.insert(0, s.substring(0, i));
                break;
            }
        }

        return sb.toString();
    }
}