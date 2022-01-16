// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
// algorithms
// Easy (65.12%)
// Total Accepted: 10,139
// Total Submissions: 15,570


class Solution {
    
    public String[] divideString(String s, int k, char fill) {
        int sLen = s.length();
        int divRes = sLen / k;
        int remainder = sLen % k;
        int resLen = remainder == 0 ? divRes : divRes + 1;
        
        String[] res = new String[resLen];
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            if (sb.length() == k) {
                res[idx++] = sb.toString();
                sb.setLength(0);
            }
        }
        
        int curSbLen = sb.length();
        if (curSbLen != 0 && curSbLen < k) {
            for (int i = 0; i < k - curSbLen; i++) {
                sb.append(fill);
            }
            res[idx] = sb.toString();
        }
        
        return res;
    }
    
}