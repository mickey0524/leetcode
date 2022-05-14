// https://leetcode.com/problems/largest-3-same-digit-number-in-string/
// algorithms
// Easy (58.5%)
// Total Accepted: 15,836
// Total Submissions: 27,071


class Solution {
    
    public String largestGoodInteger(String num) {
        int len = num.length();
        if (len < 3) {
            return "";
        }
        
        int preIdx = 0;
        int curN = -1;
        String res = "";
        for (int i = 1; i < len; i++) {
            if (num.charAt(i) != num.charAt(i - 1)) {
                preIdx = i;
            } else if (i - preIdx == 2 && ((int) (num.charAt(i) - '0') > curN)) {
                curN = num.charAt(i) - '0';
                res = num.substring(preIdx, i + 1);
            }
        }
        
        return res;
    }
    
}
