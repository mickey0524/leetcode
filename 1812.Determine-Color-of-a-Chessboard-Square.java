// https://leetcode.com/problems/determine-color-of-a-chessboard-square/
// algorithms
// Easy (77.8%)
// Total Accepted: 5,995
// Total Submissions: 7,705


class Solution {
    public boolean squareIsWhite(String coordinates) {
        char[] chArr = coordinates.toCharArray();
        int tmp = chArr[1] - '0';
        
        if (chArr[0] == 'a' || chArr[0] == 'c' || chArr[0] == 'e' || chArr[0] == 'g') {
            return (tmp & 1) == 0;
        } else {
            return (tmp & 1) == 1;
        }
    }
}