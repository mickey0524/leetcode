// https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
// algorithms
// Easy (63.1%)
// Total Accepted: 11.8K
// Total Submissions: 18.7K


class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch - 'a' + 1);
        }
        String str = sb.toString();
        
        // System.out.println(str);
        
        int res = 0;
        
        for (int i = 0; i < k; i++) {
            res = 0;
            
            for (char ch : str.toCharArray()) {
                res += ch - '0';
            }
            
            str = String.valueOf(res);
        }
        
        return res;
    }
}