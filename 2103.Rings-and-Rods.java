// https://leetcode.com/problems/rings-and-rods/
// algorithms
// Easy (79.35%)
// Total Accepted: 7.3K
// Total Submissions: 9.2K


class Solution {
    
    public int countPoints(String rings) {
        Map<Character, Set<Character>> map = new HashMap<>(16);
        
        int len = rings.length();
        for (int i = 0; i < len; i += 2) {
            Set<Character> set = map.get(rings.charAt(i + 1));
            if (set == null) {
                set = new HashSet<>();
                map.put(rings.charAt(i + 1), set);
            }
            
            set.add(rings.charAt(i));
        }
        
        int res = 0;
        for (Set<Character> s : map.values()) {
            if (s.size() == 3) {
                res++;
            }
        }
        
        return res;
    }
    
}