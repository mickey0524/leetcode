// https://leetcode.com/problems/valid-parentheses/
//
// algorithms
// Easy (36.54%)
// Total Accepted: 596,053
// Total Submissions: 1,631,303
// beats 100.0% of java submissions


class Solution {
    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.offerFirst(ch);
            } else if (stack.isEmpty() || stack.peekFirst() != map.get(ch)) {
                return false;
            } else {
                stack.pollFirst();
            }
        }
        
        return stack.isEmpty();
    }
}