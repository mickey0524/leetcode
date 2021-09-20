// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
// algorithms
// Easy (92.7%)
// Total Accepted: 8.9K
// Total Submissions: 9.6K


class Solution {
    
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        
        for (String o : operations) {
            if ("--X".equals(o) || "X--".equals(o)) {
                res--;
            } else {
                res++;
            }
        }
        
        return res;
    }
}