// https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
// algorithms
// Medium (38.44%)
// Total Accepted: 4,831
// Total Submissions: 12,569


class Solution {

    private static final char LEFT_BRACKETS = '(';

    private static final char RIGHT_BRACKETS = ')';

    public int minInsertions(String s) {
        int len = s.length();
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> doubleRight = new LinkedList<>();
        LinkedList<Integer> singleRight = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == LEFT_BRACKETS) {
                left.offerLast(i);
            } else {
                if (i < len - 1 && s.charAt(i + 1) == RIGHT_BRACKETS) {
                    if (!left.isEmpty()) {
                        left.pollLast();
                    } else {
                        doubleRight.offerLast(i);
                    }
                    i++;
                } else {
                    singleRight.offerLast(i);
                }
            }
        }

        int res = doubleRight.size();
        if (!left.isEmpty()) {
            while (!singleRight.isEmpty()) {
                int idx = singleRight.peekLast();
                while (!left.isEmpty() && left.peekLast() > idx) {
                    left.pollLast();
                    res += 2;
                }
                if (!left.isEmpty()) {
                    res++;
                    left.pollLast();
                    singleRight.pollLast();
                } else {
                    break;
                }
            }
        }

        res += left.size() * 2;
        res += singleRight.size() * 2;

        return res;

    }
}