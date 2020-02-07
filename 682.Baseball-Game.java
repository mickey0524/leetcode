// https://leetcode.com/problems/baseball-game/
//
// algorithms
// Easy (62.41%)
// Total Accepted: 67,168
// Total Submissions: 107,627


class Solution {
    public int calPoints(String[] ops) {
        int res = 0;
        LinkedList<Integer> l = new LinkedList<>();
        int tmp;

        for (String op : ops) {
            if (op.equals("+")) {
                int pre = l.pollLast();
                tmp = pre + l.peekLast();
                l.offer(pre);
                l.offer(tmp);
                res += tmp;
            } else if (op.equals("D")) {
                tmp = l.peekLast() * 2;
                l.offer(tmp);
                res += tmp;
            } else if (op.equals("C")) {
                tmp = l.pollLast();
                res -= tmp;
            } else {
                tmp = Integer.valueOf(op);
                l.offer(tmp);
                res += tmp;
            }
        }

        return res;
    }
}