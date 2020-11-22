// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
// algorithms
// Easy (88.76%)
// Total Accepted: 5,767
// Total Submissions: 6,497
// beats 100.0% of java submissions


class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = join(word1);
        String s2 = join(word2);
        
        return s1.equals(s2);
    }
    
    private String join(String[] str) {
        StringBuilder sb = new StringBuilder();
        
        for (String s : str) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}