// https://leetcode.com/problems/array-transformation/
//
// algorithms
// Easy (54.52%)
// Total Accepted: 3,208
// Total Submissions: 5,884
// beats 100.0% of java submissions


class Solution {
    public int minimumSwap(String s1, String s2) {
        int len = s1.length();
        int x = 0, y = 0;

        for (int i = 0; i < len; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                if (c1 == 'x') {
                    x++;
                } else {
                    y++;
                }
            }
        }

        int res = x / 2 + y / 2;
        x %= 2;
        y %= 2;

        if (x != y) {
            return -1;
        }

        return res + x * 2;
    }
}