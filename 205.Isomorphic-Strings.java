// https://leetcode.com/problems/isomorphic-strings/
//
// algorithms
// Easy (37.04%)
// Total Accepted:    195,850
// Total Submissions: 528,728

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        
        HashMap<Character, Character> tMap = new HashMap<>();
        HashMap<Character, Character> sMap = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            char tCh = t.charAt(i);
            char sCh = s.charAt(i);
            
            if (tMap.containsKey(tCh)) {
                if (sCh != tMap.get(tCh)) {
                    return false;
                }
            } else {
                tMap.put(tCh, sCh);
            }
            
            if (sMap.containsKey(sCh)) {
                if (tCh != sMap.get(sCh)) {
                    return false;
                }
            } else {
                sMap.put(sCh, tCh);
            }
        }
        
        return true;
    }
}