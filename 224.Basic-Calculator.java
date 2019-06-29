// https://leetcode.com/problems/basic-calculator/
//
// algorithms
// Hard (33.01%)
// Total Accepted:    110,510
// Total Submissions: 334,771

class Solution {
    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        
        char[] chArr = s.toCharArray();
        int len = chArr.length, i = 0;
        int flag = 1;
        boolean firstNum = true;
        int cur = 0;
        
        while (i < len) {
            if (chArr[i] == ' ') {
                i++;
                continue;
            } else if (chArr[i] == '+') {
                flag = 1;
            } else if (chArr[i] == '-') {
                flag = -1;
            } else if (chArr[i] == '(') {
                stack.offerLast(cur);
                stack.offerLast(flag);
                firstNum = true;
            } else if (chArr[i] == ')') {
                flag = stack.pollLast();
                cur = stack.pollLast() + (flag * cur);
            } else {
                int j = i + 1;
                while (j < len && Character.isDigit(chArr[j])) {
                    j++;
                }
                int num = Integer.valueOf(s.substring(i, j));
                if (firstNum) {
                    firstNum = false;
                    cur = num;
                } else {
                    cur += flag * num;
                }
                i = j - 1;
            }
            i++;
        }
        
        return cur;
    }
}