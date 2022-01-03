// https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
// algorithms
// Medium (82.85%)
// Total Accepted: 9,993
// Total Submissions: 12,061


class Solution {
    
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        if (m < 2) {
            return 0;
        }
        int n = bank[0].length();
        
        int preNum = 0;
        int res = 0;
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (char ch : bank[i].toCharArray()) {
                if (ch == '1') {
                    tmp++;
                }
            }
            if (tmp > 0) {
                res += preNum * tmp;
                preNum = tmp;
            }
        }
        
        return res;
    }
    
}