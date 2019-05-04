// https://leetcode.com/problems/basic-calculator-ii/
//
// algorithms
// Medium (33.20%)
// Total Accepted:    105,781
// Total Submissions: 318,617

class Solution {
    public int calculate(String s) {
        s = s.trim();

        LinkedList<String> stack = new LinkedList<>();
        int len = s.length(), i = 0;

        while (i < len) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int j = i;
                while (j < len && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++;
                }
                stack.offer(s.substring(i, j));
                i = j;
            } else if (ch == '+' || ch == '-') {
                stack.offer(s.substring(i, i + 1));
                i++;
            } else if (ch == '*' || ch == '/') {
                i++;
                while (s.charAt(i) == ' ') {
                    i++;
                }
                int j = i;
                while (j < len && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++;
                }
                int preNum = Integer.valueOf(stack.pollLast());
                int nextNum = Integer.valueOf(s.substring(i, j));
                if (ch == '*') {
                    stack.offer(String.valueOf(preNum * nextNum));
                } else {
                    stack.offer(String.valueOf(preNum / nextNum));
                }
                i = j;
            } else {
                i++;
            }
        }

        int res = Integer.valueOf(stack.pollFirst());
        int op = 1;
        
        while (stack.size() > 0) {
            String str = stack.pollFirst();
            if (str.equals("-")) {
                op = -1;
            } else if (str.equals("+")) {
                op = 1;
            } else {
                res = res + (op * Integer.valueOf(str));
            }
        }

        return res;

    }
}