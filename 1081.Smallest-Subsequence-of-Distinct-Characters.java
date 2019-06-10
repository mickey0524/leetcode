// https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
//
// algorithms
// Medium (38.69%)
// Total Accepted: 1,667
// Total Submissions: 4,311
// beats 100.0% of java submissions

class Solution {
    public String smallestSubsequence(String text) {
        int len = text.length();
        LinkedList<Character> stack = new LinkedList<>();
        
        int[] lastIdx = new int[26];
        boolean[] isUsed = new boolean[26];
        Arrays.fill(lastIdx, -1);
        for (int i = 0; i < len; i++) {
            lastIdx[text.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            while (!isUsed[ch - 'a'] && !stack.isEmpty()) {
                char last = stack.peekLast();
                if (ch <= last && lastIdx[last - 'a'] >= i) {
                    stack.pollLast();
                    isUsed[last - 'a'] = false;
                } else {
                    break;
                }
            }
            
            if (!isUsed[ch - 'a']) {
                stack.offerLast(ch);
                isUsed[ch - 'a'] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
}