// https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
// algorithms
// Medium (56.58%)
// Total Accepted: 82.1K
// Total Submissions: 145.1K


class Solution {
    
    public boolean hasAllCodes(String s, int k) {
        int len = s.length();
        if (len <= k) {
            return false;
        }
        
        Set<String> set = new HashSet<>();
        for (int i = k; i <= len; i++) {
            set.add(s.substring(i - k, i));
        }
        
        return set.size() == (int) Math.pow(2, k);
    }
    
}