// https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
// algorithms
// Easy (83.25%)
// Total Accepted: 10,573
// Total Submissions: 12,701


class Solution {
    
    public List<String> cellsInRange(String s) {
        char col1 = s.charAt(0);
        int row1 = (int) (s.charAt(1) - '0');
        char col2 = s.charAt(3);
        int row2 = (int) (s.charAt(4) - '0');
        int beginIdx = (int) (col1 - 'A');
        int endIdx = (int) (col2 - 'A');
        
        List<String> res = new ArrayList<>();
        for (int i = beginIdx; i <= endIdx; i++) {
            for (int j = row1; j <= row2; j++) {
                res.add((char) (i + 'A') + String.valueOf(j));
            }
        }
        
        return res;
    }
    
}