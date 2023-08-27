// https://leetcode.com/problems/faulty-keyboard/description/
// algorithms
// Easy (82.5%)
// Total Accepted: 37.5K
// Total Submissions: 45.5K


class Solution {

    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == 'i') {
                sb = sb.reverse();
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

}