// https://leetcode.com/problems/greatest-common-divisor-of-strings/
//
// algorithms
// Easy (45.78%)
// Total Accepted: 2,407
// Total Submissions: 5,258
// beats 100.0% of java submissions


class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int maxLen = Math.min(len1, len2);
        
        for (int i = maxLen; i >= 1; i--) {
            if (len1 % i == 0 && len2 % i == 0 && str1.substring(0, i).equals(str2.substring(0, i))) {
                String tmp1 = str1.substring(i) + str1.substring(0, i);
                String tmp2 = str2.substring(i) + str2.substring(0, i);
                if (tmp1.equals(str1) && tmp2.equals(str2)) {
                    return str1.substring(0, i);
                }
            }
        }
        
        return "";
    }
}