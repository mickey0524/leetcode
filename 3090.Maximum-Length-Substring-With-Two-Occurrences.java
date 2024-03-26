// https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/
// algorithms
// Easy (62.2%)
// Total Accepted: 25.6K
// Total Submissions: 41.1K


class Solution {

    public int maximumLengthSubstring(String s) {
        int[] nums = new int[26];
        int sLen = s.length();
        int beforeIdx = 0;
        int res = 0;

        for (int i = 0; i < sLen; i++) {
            char ch = s.charAt(i);
            int chIdx = ch - 'a';
            nums[chIdx] += 1;

            while (beforeIdx < i && nums[chIdx] > 2) {
                nums[s.charAt(beforeIdx) - 'a'] -= 1;
                beforeIdx += 1;
            }
            
            res = Math.max(res, i - beforeIdx + 1);
        }
        
        return res;
    }

}