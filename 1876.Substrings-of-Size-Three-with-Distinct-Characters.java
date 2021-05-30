// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
// algorithms
// Easy (65.19%)
// Total Accepted: 8,832
// Total Submissions: 13,549


class Solution {
    public int countGoodSubstrings(String s) {
        char[] chArr = s.toCharArray();
        int len = chArr.length;
        if (len < 3) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < 3; i++) {
            map.put(chArr[i], map.getOrDefault(chArr[i], 0) + 1);
        }
        if (map.size() == 3) {
            res++;
        }
        
        for (int i = 3; i < len; i++) {
            map.put(chArr[i], map.getOrDefault(chArr[i], 0) + 1);
            int tmp = map.get(chArr[i - 3]);
            if (tmp == 1) {
                map.remove(chArr[i - 3]);    
            } else {
                map.put(chArr[i - 3], tmp - 1);
            }
            
            if (map.size() == 3) {
                res++;
            }
        }
        
        return res;
    }
}