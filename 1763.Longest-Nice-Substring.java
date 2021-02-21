// https://leetcode.com/problems/longest-nice-substring/
// algorithms
// Easy (59.71%)
// Total Accepted: 4,824
// Total Submissions: 8,079


class Solution {
    
    public String longestNiceSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] chArr = s.toCharArray();
        int len = chArr.length;
        
        for (char ch : chArr) {
            set.add(ch);
        }
        
        for (int i = 0; i < len; i++) {
            if ((Character.isUpperCase(chArr[i]) && !set.contains(Character.toLowerCase(chArr[i]))) ||
               (Character.isLowerCase(chArr[i]) && !set.contains(Character.toUpperCase(chArr[i])))) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                
                return left.length() >= right.length() ? left : right;
            }
        }
        
        return s;
    }
    
}