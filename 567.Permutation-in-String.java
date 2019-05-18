// https://leetcode.com/problems/permutation-in-string/
//
// algorithms
// Medium (38.28%)
// Total Accepted: 45,733
// Total Submissions: 119,453
// beats 93.17% of java submissions


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }

        int[] chs = new int[26];

        for (char ch : s1.toCharArray()) {
            chs[ch - 'a']++;
        }

        int[] tmp = new int[26];
        for (int i = 0; i < len1; i++) {
            tmp[s2.charAt(i) - 'a']++;
        }

        for (int i = len1; i < len2; i++) {
            if (compareArr(chs, tmp)) {
                return true;
            }
            tmp[s2.charAt(i) - 'a']++;
            tmp[s2.charAt(i - len1) - 'a']--;
        }

        return compareArr(chs, tmp);
    }

    public boolean compareArr(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}