// https://leetcode.com/problems/check-if-a-string-can-break-another-string/
// algorithms
// Medium (65.16%)
// Total Accepted: 5,930
// Total Submissions: 9,100


class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        return helper(s1, s2) || helper(s2, s1);
    }

    /**
     * check s2 是否能打破 s1
     */
    private boolean helper(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int len = s1.length();

        for (int i = 0; i < len; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        int oweNum = 0;
        for (int i = 0; i < 26; i++) {
            int diff = arr2[i] - arr1[i];
            if (diff > 0 && diff > oweNum) {
                return Boolean.FALSE;
            }

            oweNum -= diff;
        }

        return Boolean.TRUE;
    }
}