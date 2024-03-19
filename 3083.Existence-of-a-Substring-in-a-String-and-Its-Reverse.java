// https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/description/
// algorithms
// Easy (64.8%)
// Total Accepted: 29.1K
// Total Submissions: 44.9K


class Solution {

    public boolean isSubstringPresent(String s) {
        int len = s.length();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < len - 1; i++) {
            set.add(s.substring(i, i + 2));
        }

        StringBuilder sb = new StringBuilder();
        String reverseS = sb.append(s).reverse().toString();
        for (int i = 0; i < len - 1; i++) {
            if (set.contains(reverseS.substring(i, i + 2))) {
                return true;
            }
        }

        return false;
    }

}