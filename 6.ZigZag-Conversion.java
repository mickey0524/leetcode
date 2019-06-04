// https://leetcode.com/problems/zigzag-conversion/
//
// algorithms
// Medium (31.92%)
// Total Accepted: 320,984
// Total Submissions: 1,005,632

class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Character>> tmp = new ArrayList<ArrayList<Character>>(numRows);
        for (int i = 0; i < numRows; i++) {
            tmp.add(new ArrayList<Character>());
        }
        int row = 0, sample = 1;
        
        for (char ch : s.toCharArray()) {
            tmp.get(row).add(ch);
            row += sample;
            if (row == numRows) {
                row = numRows - 2;
                sample = -1;
            } else if (row == -1) {
                sample = 1;
                row = 1;
            }
        }
        
        for (int i = 0; i < numRows; i++) {
            for (char ch : tmp.get(i)) {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}