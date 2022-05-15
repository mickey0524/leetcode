// https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/
// algorithms
// Easy (52.27%)
// Total Accepted: 11,422
// Total Submissions: 21,852


class Solution {
    
    public List<String> removeAnagrams(String[] words) {
        if (words == null) {
            return Collections.emptyList();
        }
        int len = words.length;
        if (len == 0) {
            return Collections.emptyList();
        }
        if (len == 1) {
            return Arrays.asList(words[0]);
        }
        
        List<String> res = new ArrayList<>();
        int[] flag1 = buildFlagArr(words[0]);
        res.add(words[0]);
        
        for (int i = 1; i < len; i++) {
            int[] flag2 = buildFlagArr(words[i]);
            if (!checkAnagram(flag1, flag2)) {
                res.add(words[i]);
                flag1 = flag2;
            }
        }
        
        return res;
    }
    
    private int[] buildFlagArr(String w) {
        int[] flag = new int[26];
        
        for (char ch : w.toCharArray()) {
            flag[ch - 'a']++;
        }
        
        return flag;
    }
    
    private boolean checkAnagram(int[] flag1, int[] flag2) {
        int len = flag1.length;
        
        for (int i = 0; i < len; i++) {
            if (flag1[i] != flag2[i]) {
                return false;
            }
        }
        
        return true;
    } 
    
}