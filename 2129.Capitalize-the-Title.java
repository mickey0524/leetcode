// https://leetcode.com/problems/capitalize-the-title/
// algorithms
// Easy (53.19%)
// Total Accepted: 9,263
// Total Submissions: 17,415


class Solution {
    
    public String capitalizeTitle(String title) {
        String[] wordArr = title.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for (String w : wordArr) {
            int wLen = w.length();
            if (wLen < 3) {
                sb.append(w.toLowerCase())
                    .append(' ');
            } else {
                sb.append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1).toLowerCase())
                    .append(' ');
            }
        }
        
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb.toString();
    }
    
}