// https://leetcode.com/problems/integer-to-roman/
//
// algorithms
// Medium (51.04%)
// Total Accepted: 232,284
// Total Submissions: 455,130
// beats 100.0% of java submissions


class Solution {
    public String intToRoman(int num) {
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            while (num < values[idx]) {
                idx++;
            }
            int divRes = num / values[idx];
            num %= values[idx];
            for (int i = 0; i < divRes; i++) {
                sb.append(romans[idx]);
            }
        }
        
        return sb.toString();
    }
}