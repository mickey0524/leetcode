// https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/
// algorithms
// Easy (73.33%)
// Total Accepted: 11,895
// Total Submissions: 16,222

class Solution {
    
    public boolean checkString(String s) {
        boolean visitB = false;
        
        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                visitB = true;
            } else if (visitB) {
                return false;
            }
        }
        
        return true;
    }
    
}