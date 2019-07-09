// https://leetcode.com/problems/defanging-an-ip-address/
//
// algorithms
// Easy (90.13%)
// Total Accepted: 7,115
// Total Submissions: 7,894
// beats 100.0% of java submissions


class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();

        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                sb.append('[').append(ch).append(']');
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}