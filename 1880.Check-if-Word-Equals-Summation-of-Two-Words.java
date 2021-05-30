// https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
// algorithms
// Easy (75.69%)
// Total Accepted: 7,984
// Total Submissions: 10,548


class Solution {
 
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int firstValue = Integer.parseInt(toIntString(firstWord));
        int secondValue = Integer.parseInt(toIntString(secondWord));
        int targetValue = Integer.parseInt(toIntString(targetWord));
        
        return (firstValue + secondValue) == targetValue;
    }
    
    private String toIntString(String word) {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : word.toCharArray()) {
            sb.append(ch - 'a');
        }
        
        return sb.toString();
    }
    
}