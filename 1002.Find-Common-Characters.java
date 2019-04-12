// https://leetcode.com/problems/find-common-characters/
//
// algorithms
// Easy (66.61%)
// Total Accepted:    14,803
// Total Submissions: 22,225
// beats 95.22% of java submissions

class Solution {
    public List<String> commonChars(String[] A) {
        int ch[] = new int[26];
        Arrays.fill(ch, 101);
        
        for (String s : A) {
            int tmp[] = new int[26];
            for (char c : s.toCharArray()) {
                tmp[c - 'a']++;
            }
            getSmaller(ch, tmp);
        }
        
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            String s = String.valueOf((char)(i + 'a'));
            for (int j = 0; j < ch[i]; j++) {
                res.add(s);
            }
        }
        
        return res;
    }
    
    public void getSmaller(int[] ch, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (ch[i] > b[i]) {
                ch[i] = b[i];
            }
        }
    }
}