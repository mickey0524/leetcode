// https://leetcode-cn.com/problems/check-permutation-lcci/
// algorithms
// Easy (69.78%)
// Total Accepted: 3,879
// Total Submissions: 5,559


class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] chArr1 = s1.toCharArray();
        char[] chArr2 = s2.toCharArray();
        Arrays.sort(chArr1);
        Arrays.sort(chArr2);

        for (int i = 0; i < chArr1.length; i++) {
            if (chArr1[i] != chArr2[i]) {
                return false;
            }
        }

        return true;
    }
}