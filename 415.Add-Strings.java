// https://leetcode.com/problems/add-strings/
//
// algorithms
// Easy (44.7%)
// Total Accepted:    114,595
// Total Submissions: 256,348


class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (len1 == 0) {
            return num2;
        }
        if (len2 == 0) {
            return num1;
        }

        LinkedList<Integer> l = new LinkedList<>();

        int idx1 = 0, idx2 = 0, carry = 0;
        while (idx1 < len1 || idx2 < len2) {
            int tmp = carry;
            if (idx1 < len1) {
                tmp += (num1.charAt(len1 - 1 - idx1) - '0');
                idx1++;
            }
            if (idx2 < len2) {
                tmp += (num2.charAt(len2 - 1 - idx2) - '0');
                idx2++;
            }

            if (tmp >= 10) {
                carry = 1;
                tmp -= 10;
            } else {
                carry = 0;
            }

            l.addFirst(tmp);
        }
        
        if (carry == 1) {
            l.addFirst(1);
        }

        StringBuilder sb = new StringBuilder();
        for (int n : l) {
            sb.append(n);
        }

        return sb.toString();
    }
}