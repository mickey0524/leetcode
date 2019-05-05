// https://leetcode.com/problems/first-unique-character-in-a-string/
//
// algorithms
// Easy (49.81%)
// Total Accepted:    258,412
// Total Submissions: 518,796

class Solution {
    public int firstUniqChar(String s) {
        int[] flag = new int[26];
        Arrays.fill(flag, -1);
        char[] chs = s.toCharArray();
        int length = chs.length;
        
        for (int i = 0; i < length; i++) {
            int idx = chs[i] - 'a';
            if (flag[idx] == -1) {
                flag[idx] = i;
            } else {
                flag[idx] = -2;
            }
        }
        
        int res = Integer.MAX_VALUE;
        
        for (int n : flag) {
            if (n >= 0) {
                res = Math.min(res, n);
            }    
        }
        
        if (res != Integer.MAX_VALUE) {
            return res;
        }
        
        return -1;
    }
}