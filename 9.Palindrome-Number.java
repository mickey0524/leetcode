// https://leetcode.com/problems/longest-common-prefix/
//
// algorithms
// Easy (43.29%)
// Total Accepted: 579,611
// Total Submissions: 1,338,862


class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        
        while (x != 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        
        return true;
    }
}
