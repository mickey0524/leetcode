// https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
// algorithms
// Easy (83.52%)
// Total Accepted: 5,549
// Total Submissions: 6,644


class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        char[] charArr = s.toCharArray();
        int len = charArr.length;
        int[] res = new int[len];
        
        for (int i = 0; i < len; i++) {
            int x = startPos[1], y = startPos[0];
            int curNum = 0;
            for (int j = i; j < len; j++) {
                if (charArr[j] == 'L') {
                    x--;
                } else if (charArr[j] == 'R') {
                    x++;
                } else if (charArr[j] == 'U') {
                    y--;
                } else {
                    y++;
                } 
                
                if (x < 0 || x >= n || y < 0 || y >= n) {
                    break;
                }
                curNum++;
            }
            
            res[i] = curNum;
        }
        
        return res;
    }
}