// https://leetcode-cn.com/problems/is-unique-lcci/
// algorithms
// Easy (73.4%)
// Total Accepted: 5,443
// Total Submissions: 7,416


class Solution {
    public boolean isUnique(String astr) {
        HashSet<Character> set = new HashSet<>();

        for (char ch : astr.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            }

            set.add(ch);
        }

        return true;
    }
}