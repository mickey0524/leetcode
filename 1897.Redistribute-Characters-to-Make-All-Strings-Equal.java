// https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
// algorithms
// Easy (48.88%)
// Total Accepted: 8.7K
// Total Submissions: 15.2K


class Solution {

    public boolean makeEqual(String[] words) {
        int[] arr = new int[26];
        int len = words.length;

        for (String w : words) {
            for (char ch : w.toCharArray()) {
                arr[ch - 'a']++;
            }
        }

        for (int n : arr) {
            if (n % len != 0) {
                return false;
            }
        }

        return true;
    }

}