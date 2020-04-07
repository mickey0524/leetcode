// https://leetcode.com/problems/construct-k-palindrome-strings/
// algorithms
// Medium (55.91%)
// Total Accepted: 4,344
// Total Submissions: 7,770


class Solution {
    public boolean canConstruct(String s, int k) {
        int len = s.length();
        if (len < k) {
            return false;
        }

        int[] charNum = new int[26];
        for (char ch : s.toCharArray()) {
            charNum[ch - 'a']++;
        }
        int oddNum = 0;
        for (int n : charNum) {
            if ((n & 1) == 1) {
                oddNum++;
            }
        }
        if (oddNum > k) {
            return false;
        }

        return true;
    }
}