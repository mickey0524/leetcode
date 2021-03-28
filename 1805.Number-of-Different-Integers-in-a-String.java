// https://leetcode.com/problems/number-of-different-integers-in-a-string/
// algorithms
// Easy (36.61%)
// Total Accepted: 5,806
// Total Submissions: 15,860


class Solution {
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        char[] chArr = word.toCharArray();
        int len = chArr.length;
        
        int idx = 0;
        while (idx < len) {
            if (!Character.isDigit(chArr[idx])) {
                idx++;
                continue;
            }
            
            int j = idx + 1;
            while (j < len && Character.isDigit(chArr[j])) {
                j++;
            }
            
            set.add(removeZero(word.substring(idx, j)));
            idx = j;
        }
        
        return set.size();
    }
    
    private String removeZero(String tmp) {
        int len = tmp.length();
        for (int i = 0; i < len; i++) {
            if (tmp.charAt(i) != '0') {
                return tmp.substring(i);
            }
        }
        
        return "0";
    }
}