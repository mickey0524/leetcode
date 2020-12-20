// https://leetcode.com/problems/reformat-phone-number/
// algorithms
// Easy (68.73%)
// Total Accepted: 4,789
// Total Submissions: 6,968


class Solution {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : number.toCharArray()) {
            if (ch == ' ' || ch == '-') {
                continue;
            }
            
            sb.append(ch);
        }
        
        number = sb.toString();
        sb = new StringBuilder();
        int len = number.length();
        int i = 0;
        
        for (; i < len - 4; i += 3) {
            sb.append(number.substring(i, i + 3)).append('-');
        }
        
        if (i == len - 4) {
            sb.append(number.substring(i, i + 2)).append('-').append(number.substring(i + 2, i + 4));
        } else {
            sb.append(number.substring(i));
        }
        
        return sb.toString();
    }
}