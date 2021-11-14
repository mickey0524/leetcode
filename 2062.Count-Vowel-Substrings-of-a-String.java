// https://leetcode.com/problems/count-vowel-substrings-of-a-string/
// algorithms
// Easy (66%)
// Total Accepted: 9.9K
// Total Submissions: 15K


class Solution {
    
    private static Set<Character> VOMEL_SET = new HashSet<>();
    
    static {
        VOMEL_SET.add('a');
        VOMEL_SET.add('e');
        VOMEL_SET.add('i');
        VOMEL_SET.add('o');
        VOMEL_SET.add('u');
    }
    
    public int countVowelSubstrings(String word) {
        int len = word.length();
        if (len < 5) {
            return 0;
        }
        int preIdx = 0, res = 0;
    
        
        for (int i = 0; i < len; i++) {
            if (!VOMEL_SET.contains(word.charAt(i))) {
                if (i - preIdx >= 5) {
                    res += helper(word.substring(preIdx, i));
                }
                preIdx = i + 1;
            }
        }
        
        res += helper(word.substring(preIdx));
        
        return res;
    }
    
    private int helper(String word) {
        int len = word.length();
        if (len < 5) {
            return 0;
        }
        
        int res = 0;
        for (int i = 5; i <= len; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < i - 1; j++) {
                char ch = word.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            
            for (int j = i - 1; j < len; j++) {
                char ch = word.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                
                if (j >= i) {
                    ch = word.charAt(j - i);
                    map.put(ch, map.get(ch) - 1);
                }
                
                boolean isOk = true;
                for (char c : VOMEL_SET) {
                    if (map.getOrDefault(c, 0) == 0) {
                        isOk = false;
                        break;
                    }
                }
                
                if (isOk) {
                    res++;
                }
            }
        }
        
        return res;
    }
    
}