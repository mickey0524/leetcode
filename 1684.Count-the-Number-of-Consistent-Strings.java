// https://leetcode.com/problems/count-the-number-of-consistent-strings/
// algorithms
// Easy (88.25%)
// Total Accepted: 5,323
// Total Submissions: 6,032


class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        
        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }
        
        int res = 0;
        for (String w : words) {
            boolean match = true;
            
            for (char ch : w.toCharArray()) {
                if (!set.contains(ch)) {
                    match = false;
                    break;
                }
            }
            
            if (match) {
                res++;
            }
        }
        
        return res;
    }
}