// https://leetcode.com/problems/sort-list/
//
// algorithms
// Medium (31.98%)
// Total Accepted:    159,034
// Total Submissions: 497,231


class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<String> s = new LinkedList<>();

        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int next = Integer.valueOf(s.pollLast());
                int pre = Integer.valueOf(s.pollLast());
                int res = 0;

                switch (t) {
                    case "+": res = pre + next; break;
                    case "-": res = pre - next; break;
                    case "*": res = pre * next; break;
                    case "/": res = pre / next; break;
                    default: break;
                }
                s.offer(String.valueOf(res));
            } else {
                s.offer(t);
            }
        }

        return Integer.valueOf(s.peek());
    }
}