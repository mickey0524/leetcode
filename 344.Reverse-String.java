// https://leetcode.com/problems/reverse-string/
//
// algorithms
// Easy (63.15%)
// Total Accepted:    414,193
// Total Submissions: 655,898

class Solution {
    public void reverseString(char[] s) {
        int length = s.length;
        
        for (int i = 0; i < length / 2; i++) {
            swap(s, i, length - i - 1);
        }
        
    }
    
    public void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}