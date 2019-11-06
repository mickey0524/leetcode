// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
//
// algorithms
// Medium (56.66%)
// Total Accepted: 3,930
// Total Submissions: 6,936
// beats 100.0% of java submissions


class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] chs = s.toCharArray();
        int[] rightBracketArr = new int[chs.length];
        int tmp = 0;

        for (int i = chs.length - 1; i >= 0; i--) {
            rightBracketArr[i] = tmp;
            if (chs[i] == ')') {
                tmp++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int leftBracket = 0, rightBracket = 0;
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            if (ch == '(') {
                if (rightBracketArr[i] - (leftBracket - rightBracket) > 0) {
                    sb.append('(');
                    leftBracket++;
                }
            } else if (ch == ')') {
                if (rightBracket < leftBracket) {
                    sb.append(')');
                    rightBracket++;
                }
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}