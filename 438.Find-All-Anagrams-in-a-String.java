// https://leetcode.com/problems/find-all-anagrams-in-a-string/
//
// algorithms
// Easy (36.94%)
// Total Accepted:    116,563
// Total Submissions: 315,507
// beats 100.0% of java submissions

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();
        
        if (pLen > sLen) {
            return res;
        }
                
        int pArr[] = new int[26];
        for (char ch : p.toCharArray()) {
            pArr[ch - 'a']++;
        }
        
        int sArr[] = new int[26];
        int i = 0;
        int j = 0;
        
        while (j < sLen) {
            int idx = s.charAt(j) - 'a'; 
            if (pArr[idx] == 0) {
                sArr = new int[26];
                i = j + 1;
            } else {
                sArr[idx]++;
                if (j - i + 1 == pLen) {
                    boolean isOk = true;
                    for (int k = 0; k < 26; k++) {
                        if (sArr[k] != pArr[k]) {
                            isOk = false;
                            break;
                        }
                    }
                    if (isOk) {
                        res.add(i);
                    }
                    sArr[s.charAt(i) - 'a']--;
                    i++;
                }
            }
            j++;
        }
        
        return res;
    }
}