// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
// algorithms
// Easy (85.57%)
// Total Accepted: 11,156
// Total Submissions: 13,037
// beats 100.0% of java submissions


class Solution {

    private static final char LEFT_BRACKETS = '(';

    private static final char RIGHT_BRACKETS = ')';

    public int maxDepth(String s) {
        int curDepth = 0;
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == LEFT_BRACKETS) {
                curDepth++;
            } else if (ch == RIGHT_BRACKETS) {
                curDepth--;
            }

            maxDepth = Math.max(curDepth, maxDepth);
        }

        return maxDepth;
    }
}