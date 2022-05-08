// https://leetcode.com/problems/calculate-digit-sum-of-a-string/
// algorithms
// Easy (65.95%)
// Total Accepted: 17,131
// Total Submissions: 25,976


class Solution {
    
    public String digitSum(String s, int k) {
        int sLen = s.length();
        if (sLen <= k) {
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sLen; i += k) {
            String tmp = s.substring(i, Math.min(sLen, i + k));
            sb.append(bitCntAndStr(tmp));
        }
        
        return digitSum(sb.toString(), k);
    }
    
    private String bitCntAndStr(String s) {
        int res = 0;
        
        for (char ch : s.toCharArray()) {
            res += (ch - '0');
        }
        
        return String.valueOf(res);
    }
    
}