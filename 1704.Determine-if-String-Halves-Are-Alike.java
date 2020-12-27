// https://leetcode.com/problems/determine-if-string-halves-are-alike/
// algorithms
// Easy (79.84%)
// Total Accepted: 4,983
// Total Submissions: 6,241


class Solution {
    
    private static final Set<Character> vowelSet = new HashSet<>();
    
    static {
        vowelSet.add('a');
        vowelSet.add('A');
        vowelSet.add('e');
        vowelSet.add('E');
        vowelSet.add('i');
        vowelSet.add('I');
        vowelSet.add('o');
        vowelSet.add('O');
        vowelSet.add('u');
        vowelSet.add('U');
    }
    
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        String head = s.substring(0, len / 2);
        String tail = s.substring(len / 2);
        
        return getVowelNum(head) == getVowelNum(tail);
    }
    
    private int getVowelNum(String s) {
        int vowelNum = 0;
        
        for (char ch : s.toCharArray()) {
            if (vowelSet.contains(ch)) {
                vowelNum++;
            }
        }
        
        return vowelNum;
    }
}