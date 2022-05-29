// https://leetcode.com/problems/rearrange-characters-to-make-target-string/
// algorithms
// Easy (55.75%)
// Total Accepted: 12.6K
// Total Submissions: 22.6K


class Solution {
    
    public int rearrangeCharacters(String s, String target) {
        int[] sArr = strToIntArr(s);
        int[] tArr = strToIntArr(target);
        
        int res = 0;
        while (true) {
            for (int i = 0; i < 26; i++) {
                if (tArr[i] > 0) {
                    if (sArr[i] < tArr[i]) {
                        return res;
                    }
                    sArr[i] -= tArr[i];
                }
            }
            
            res++;
        }
    }
    
    private int[] strToIntArr(String s) {
        int[] res = new int[26];
        
        for (char ch : s.toCharArray()) {
            res[ch - 'a']++;
        }
        
        return res;
    }
    
}