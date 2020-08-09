// https://leetcode.com/problems/make-the-string-great/
// algorithms
// Easy (52.17%)
// Total Accepted: 7,264
// Total Submissions: 13,930
// beats 100.0% of java submissions


class Solution {
    public String makeGood(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }

        LinkedList<Character> stack = new LinkedList<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.offerLast(ch);
            } else if (satisfy(stack.peekLast(), ch)) {
                stack.pollLast();
            } else {
                stack.offerLast(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pollLast());
        }

        return sb.toString();
    }

    private boolean satisfy(char ch1, char ch2) {
        if (ch1 == ch2) {
            return false;
        }

        return Character.toLowerCase(ch1) == Character.toLowerCase(ch2);
    }
}