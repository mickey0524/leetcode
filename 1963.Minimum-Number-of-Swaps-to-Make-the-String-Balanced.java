// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
// algorithms
// Medium (62.5%)
// Total Accepted: 9.5K
// Total Submissions: 15.2K


class Solution {

    private static final char LEFT_BRACKETS = '[';

    private static final char RIGHT_BRACKETS = ']';

    public int minSwaps(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chArr = s.toCharArray();

        for (char ch : chArr) {
            if (stack.isEmpty() || LEFT_BRACKETS == ch) {
                stack.offerLast(ch);
            } else if (stack.peekLast() == LEFT_BRACKETS) {
                stack.pollLast();
            } else {
                stack.offerLast(ch);
            }
        }

        if (stack.isEmpty()) {
            return 0;
        }

        int pair = stack.size() / 2;
        
        return (pair + 1) / 2;
    }

}