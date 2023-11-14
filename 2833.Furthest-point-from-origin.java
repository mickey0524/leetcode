// https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/description/
// algorithms
// Easy (63.24%)
// Total Accepted: 38.7K
// Total Submissions: 61.2K

class Solution {

    private static final char L = 'L';
    private static final char R = 'R';
    private static final char ANY = '_';

    public int furthestDistanceFromOrigin(String moves) {
        int lNum = 0;
        int rNum = 0;
        int anyNum = 0;

        for (char ch : moves.toCharArray()) {
            if (L == ch) {
                lNum++;
            } else if (R == ch) {
                rNum++;
            } else if (ANY == ch) {
                anyNum++;
            }
        }
        
        return Math.abs(lNum - rNum) + anyNum;
    }

}